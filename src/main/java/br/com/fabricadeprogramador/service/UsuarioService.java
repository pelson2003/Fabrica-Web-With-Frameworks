package br.com.fabricadeprogramador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;

// Spring Gerencie esse objeto e suas dependencias.
@Service

public class UsuarioService {

	@Autowired
	@Qualifier(value="usuarioDAOJPA")
	UsuarioDAO usuarioDAO;

	
	@Transactional
	public Usuario salvar(Usuario usuario) throws ServiceException{
		// Verificação.
		Usuario usuarioExistente = usuarioDAO.buscarLogin(usuario.getLogin());
		// Existe
		if (usuarioExistente!=null){
			throw new ServiceException("Usuário já Existe");
		} 
		return usuarioDAO.salvar(usuario);
	}

	public void excluir(Usuario usuario) throws ServiceException {
		try {
			usuarioDAO.excluir(usuario);
		} catch (DAOException e) {
			throw new ServiceException(e);
			//e.printStackTrace();
		}
	}
	
	public Usuario buscarporID(int id) {
		return usuarioDAO.buscarporID(id);
	}
	public List<Usuario> buscarTodos() {
		return usuarioDAO.buscarTodos();
	}
	
	public Usuario buscarLogin(String login){
		return usuarioDAO.buscarLogin(login);
	}
	
}
