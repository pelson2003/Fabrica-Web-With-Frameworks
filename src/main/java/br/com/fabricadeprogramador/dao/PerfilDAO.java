package br.com.fabricadeprogramador.dao;

import java.util.List;

import br.com.fabricadeprogramador.entidade.Perfil;

public interface PerfilDAO {


	public Perfil salvar(Perfil perfil);
	public Perfil buscarporID(int id);
	public List<Perfil> buscarTodos();
	public void excluir(Perfil perfil) throws DAOException;
	

	
}
