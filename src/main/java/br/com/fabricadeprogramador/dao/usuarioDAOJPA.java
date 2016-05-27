package br.com.fabricadeprogramador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.entidade.Usuario;

@Repository // Mesma coisa que colocar um bean no XML
public class usuarioDAOJPA implements UsuarioDAO {

	@PersistenceContext
	EntityManager em;

	public usuarioDAOJPA(EntityManager em) {
		this.em = em;
	}

	public usuarioDAOJPA() {
	}

	// Insert ou Salvar
	@Transactional // Spring intercepta, e faz o processo de em. que comentamos abaixo.
	public Usuario salvar(Usuario usuario) {
		// em.getTransaction().begin();
		Usuario u = em.merge(usuario);
		// em.getTransaction().commit();
		return u;
	}

	// Buscar por ID
	public Usuario buscarporID(int id) {
		return em.find(Usuario.class, id);

	}

	// Buscar Lista de Usuários
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		Query q = em.createQuery("select u from Usuario u");

		return q.getResultList();

	}

	@Transactional // Spring Intercepta e efetuada o processo do entity manager
	public void excluir(Usuario usuario) throws DAOException {
		try {
			// tirar ele de detached para conseguir excluir
			Usuario usuManaged = em.getReference(Usuario.class, usuario.getId());
			//Usuario usuManaged = em.find(Usuario.class, usuario.getId()) ... tenta usar o cache
			//Usuario usuManaged2 = buscarporID(usuario.getId()); //... tenta usar o cache
			em.remove(usuManaged);
		} catch (Exception e) {
			throw new DAOException("Nao foi possivel excluir:", e);
		}
	}

	@Override
	public Usuario buscarLogin(String login) {

		try {
			Query q = em.createQuery("select u from Usuario u where u.login=:loginParam");
			q.setParameter("loginParam", login);
			q.setMaxResults(1);
			return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			//throw new DAOException("Registro nao encontrado", e);
			return null;
		}
	}

}
