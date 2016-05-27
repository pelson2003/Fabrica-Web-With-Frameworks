package fabricaweb2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.dao.usuarioDAOJPA;
import br.com.fabricadeprogramador.entidade.Usuario;



public class TesteHibernate {

	
	
	public static void main(String[] args) {
		
		
		
//		//Fabrica de Entity Manager
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fabricawebdb2");
//		
//		//Gerenciados de Entidades
//		EntityManager em = emf.createEntityManager();

		//Criando um objeto a ser persistido
		//emf.close();
		
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManageFactory");
		
		EntityManager em = emf.createEntityManager();
		
		
		Usuario usu = new Usuario();
		usu.setNome("Maria");
		usu.setLogin("mar");
		usu.setSenha("123");
		
		usuarioDAOJPA usuarioDAO = new usuarioDAOJPA(em);
		
		// Grava o usuario acima
		usuarioDAO.salvar(usu);
		
		
		// PROCESSO DE MODIFICAÇAO DE USUARIO
		
		//Buscar o usuario
		//Usuario usuModificar = usuarioDAO.buscarporID(4);
		
		// Muda o ID
		//usuModificar.setLogin("Bento");
		
		// Salva no Banco
		//usuarioDAO.salvar(usuModificar);
		
		
		ctx.close();
		
		// e vc pode exlcuir o colabborador
		
		// usuarioDAO.excluir(usuModificar);
		
		
		
		
		// PROCESSO SEM USUARIO DAO
		
//		// Inicia a transacao
//		em.getTransaction().begin();
//
//		// Persistindo
//		em.persist(usu);
//
//		// Executa a transacao
//		em.getTransaction().commit();
		
	}

}
