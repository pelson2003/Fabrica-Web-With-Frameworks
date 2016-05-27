package br.com.fabricadeprogramador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.entidade.Perfil;

@Repository // Mesma coisa que colocar um bean no XML
public class PerfilDAOJPA implements PerfilDAO {

	@PersistenceContext
	EntityManager em;

	public PerfilDAOJPA(EntityManager em) {
		this.em = em;
	}

	public PerfilDAOJPA() {
	}

	// Insert ou Salvar
	@Transactional // Spring intercepta, e faz o processo de em. que comentamos abaixo.
	public Perfil salvar(Perfil perfil) {
		// em.getTransaction().begin();
		Perfil u = em.merge(perfil);
		// em.getTransaction().commit();
		return u;
	}

	// Buscar por ID
	public Perfil buscarporID(int id) {
		return em.find(Perfil.class, id);

	}

	// Buscar Lista de Usuários
	@SuppressWarnings("unchecked")
	public List<Perfil> buscarTodos() {
		Query q = em.createQuery("select u from Perfil u");

		return q.getResultList();

	}

	@Transactional // Spring Intercepta e efetuada o processo do entity manager
	public void excluir(Perfil perfil) throws DAOException {
		try {
			// tirar ele de detached para conseguir excluir
			Perfil usuManaged = em.getReference(Perfil.class, perfil.getId());
			//Perfil usuManaged = em.find(Perfil.class, perfil.getId()) ... tenta usar o cache
			//Perfil usuManaged2 = buscarporID(perfil.getId()); //... tenta usar o cache
			em.remove(usuManaged);
		} catch (Exception e) {
			throw new DAOException("Nao foi possivel excluir:", e);
		}
	}



}
