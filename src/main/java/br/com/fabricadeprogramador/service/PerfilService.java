package br.com.fabricadeprogramador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.dao.PerfilDAO;
import br.com.fabricadeprogramador.entidade.Perfil;

// Spring Gerencie esse objeto e suas dependencias.
@Service

public class PerfilService {

	@Autowired
	@Qualifier(value="perfilDAOJPA")
	PerfilDAO perfilDAO;

	
	@Transactional
	public Perfil salvar(Perfil perfil) throws ServiceException{
		return perfilDAO.salvar(perfil);
	}

	public void excluir(Perfil perfil) throws ServiceException {
		try {
			perfilDAO.excluir(perfil);
		} catch (DAOException e) {
			throw new ServiceException(e);
			//e.printStackTrace();
		}
	}
	
	public Perfil buscarporID(int id) {
		return perfilDAO.buscarporID(id);
	}
	public List<Perfil> buscarTodos() {
		return perfilDAO.buscarTodos();
	}
	

	
}
