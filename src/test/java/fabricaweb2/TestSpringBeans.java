package fabricaweb2;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringBeans {
	
	
//public static void main(String[] args) {
	
	@Test	// Habilitando o JUNIT.
	public void testContextoSpring(){

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
	
	// Usuario usu = (Usuario) ctx.getBean("usuario");
	
	BasicDataSource bds = (BasicDataSource) ctx.getBean("dataSource");
	
	// System.out.println(usu.getNome());
	System.out.println(bds);
	
	ctx.close();
	
	
	
	
	
}	
}
