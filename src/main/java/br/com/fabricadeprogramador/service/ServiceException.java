package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.dao.DAOException;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(DAOException e) {
		// TODO Auto-generated constructor stub
	}

}
