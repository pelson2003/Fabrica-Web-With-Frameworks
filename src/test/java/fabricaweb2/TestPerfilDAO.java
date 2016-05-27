package fabricaweb2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fabricadeprogramador.dao.PerfilDAO;
import br.com.fabricadeprogramador.entidade.Perfil;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager") // transactional
																		// manager)

public class TestPerfilDAO {

	@Autowired
	@Qualifier(value = "perfilDAOJPA")
	PerfilDAO perfilDAO;

	@Test
	public void testsalvarPerfil() {

		Perfil p = new Perfil();
		p.setDescricao("PUBLICO");

		p = perfilDAO.salvar(p);

		Assert.assertNotNull(p.getId());
	}

}
