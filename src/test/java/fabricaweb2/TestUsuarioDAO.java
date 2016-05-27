package fabricaweb2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.dao.usuarioDAOJPA;
import br.com.fabricadeprogramador.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)

public class TestUsuarioDAO {	

	EntityManager em;
	ClassPathXmlApplicationContext ctx;
	usuarioDAOJPA usuarioDAO;
	Usuario usu;
	Usuario usuSalvo;

	@Before
	public void init() {

		// Contexto do Spring
		ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManageFactory");
		em = emf.createEntityManager();

		// Instancia usuarioDAO
		usuarioDAO = new usuarioDAOJPA(em);

		// Criando usuario

		usu = new Usuario();
		usu.setNome("Jao da Silva)");
		usu.setLogin("jj");
		usu.setSenha("123");

		// Salva o objeto usuario
		usuSalvo = usuarioDAO.salvar(usu);

	}

	@After
	public void finaliza() {
		ctx.close();
	}

	// TESTE DO JNUIT PARA O METODO SALVAR
	@Test
	public void testSalvar() {
		// Criando usuario
		// Grava o usuário DAO
		// Testa metodo Salvar
		Assert.assertNotNull(usuSalvo.getId());
	}

	@Test
	// TESTE DO JNUIT PARA O METODO SALVAR
	public void testBuscarPorID() {
		// Criando usuario
		// Grava o usuário DAO
		// Criando um novo usuário
		Integer idSalvo = usuSalvo.getId();
		Usuario usubuscado = usuarioDAO.buscarporID(idSalvo);
		Assert.assertEquals(usuSalvo, usubuscado);
	}

	@Test
	public void testExcluir() throws DAOException {
		// Criando um novo usuário
		// Salva o objeto usuario
		// Excluir o usuario
		
		usuarioDAO.excluir(usuSalvo);
		
		// Buscar por ID
		Usuario usuExcluido = usuarioDAO.buscarporID(usuSalvo.getId());

		// Validação pelo JUNIR
		Assert.assertEquals(usuExcluido, null);

	}

	@Test
	public void testBuscarTodos() {
		// Criar um UsuárioNovo
		// Salva no Banco
		// Busca por Todos
		List<Usuario> todos = usuarioDAO.buscarTodos();

		// Valida pelo JUNUIT
		// Assert.assertNotEquals(Usuario, null);
		Assert.assertTrue(todos.size() > 0);

	}

}
