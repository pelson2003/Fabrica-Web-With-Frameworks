package fabricaweb2;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;

// Carregamento pelo contexto do Spring

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager") // transactional manager)

public class TestUsuarioDAO2 {

	@Autowired
	@Qualifier("usuarioDAOJPA")
	UsuarioDAO usuarioDAO;
	//usuarioDAOJPA usuarioDAO;
	
	
	EntityManager em;
	ClassPathXmlApplicationContext ctx;
//	usuarioDAO usuarioDAO;
	Usuario usu;
	Usuario usuSalvo;

	@Before
	public void init() {

		// Contexto do Spring
		// ctx = new
		// ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		// EntityManagerFactory emf = (EntityManagerFactory)
		// ctx.getBean("entityManageFactory");
		// em = emf.createEntityManager();

		// Instancia usuarioDAO
		// usuarioDAO = new usuarioDAO(em);

		// Criando usuario

		usu = new Usuario();
		usu.setNome("newJnuit");
		usu.setLogin("jj");
		usu.setSenha("123");

		// Salva o objeto usuario
		usuSalvo = usuarioDAO.salvar(usu);

	}

	@After
	public void finaliza() {
		// ctx.close();
	}

	// TESTE DO JNUIT PARA O METODO SALVAR
	@Test
	public void testSalvar() {
		// Criando usuario
		// Grava o usuário DAO
		// Testa metodo Salvar
		Assert.assertNotNull(usuSalvo.getId());
	}

	//@Test
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
	@Transactional
	public void testExcluir() throws DAOException {
		// Criando um novo usuário
		// Salva o objeto usuario
		
		//Usuario usuaExcluir = usuarioDAO.buscarporID(usuSalvo.getId());
		
		
		// Excluir o usuario
		usuarioDAO.excluir(usuSalvo);

		// Buscar por ID
		Usuario usuExcluido = usuarioDAO.buscarporID(usuSalvo.getId());

		// Validação pelo JUNIR
		Assert.assertEquals(usuExcluido, null);

	}

	//@Test
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
