package br.com.fabricadeprogramador.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoUtil {

	static EntityManager em = null;

	public static EntityManager criarEntityManager() {
		
		if (em==null){
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("fabricawebdb2");
			@SuppressWarnings("unused")
			EntityManager em = emf.createEntityManager();
			
		} 
			return em;
		
		
		
	}

}
