package br.com.fabricadeprogramador.dao;

@SuppressWarnings("serial")
public class DAOException extends Exception {

	// Construtor recebendo a causa 
	public DAOException(String msg, Exception causa) {
		super(msg, causa);
	}
	
	// Construtor recebendo a causa 
	public DAOException(Exception causa) {
		super(causa);
	}

}
