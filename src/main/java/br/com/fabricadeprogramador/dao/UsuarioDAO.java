package br.com.fabricadeprogramador.dao;

import java.util.List;

import br.com.fabricadeprogramador.entidade.Usuario;

public interface UsuarioDAO {


	public Usuario salvar(Usuario usuario);
	public Usuario buscarporID(int id);
	public List<Usuario> buscarTodos();
	public void excluir(Usuario usuario) throws DAOException;
	public Usuario buscarLogin(String login);

	
}
