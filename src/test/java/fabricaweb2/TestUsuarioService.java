package fabricaweb2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)

// Cadastre e volte
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")

public class TestUsuarioService {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	@Qualifier("usuarioDAOJPA")
	UsuarioDAO usuarioDAO;

	@Transactional
	@Test(expected = ServiceException.class)
	public void testNaoDeveSalvar() throws ServiceException {
		Usuario usu = new Usuario();
		usu.setLogin("testsalvar3");
		usu.setSenha("123");
		usu.setNome("testsalvar3");

		usuarioDAO.salvar(usu);

		usuarioService.salvar(usu);

	}

	@Transactional
	@Test
	public void testDeveSalvar() throws ServiceException {

		Usuario usu = new Usuario();
		usu.setLogin("novousuroll");
		usu.setSenha("123");
		usu.setNome("novousuroll");

		usuarioService.salvar(usu);

		Assert.assertTrue(true);

	}

}
