package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;

// @ManagedBean (name="usuCtrl")// Mundo do JSF

@Controller(value = "usuCtrl") // Mundo do Spring
// @ManagedBean(name = "usuCtrl")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarioList;

	public UsuarioController() {
	}

	@PostConstruct
	public void init() {
		setUsuarioList(usuarioService.buscarTodos());
	}

	public void excluir(Usuario usuario) {
		try {
			usuarioService.excluir(usuario);
			usuarioList.remove(usuario);

			// MensagemUtil.mensagemInfo("Excluido com Sucesso");
			MensagemUtil.mensagemInfo(MensagemUtil.Excluido_Sucesso);

		} catch (ServiceException e) {
			//MensagemUtil.mensagemErro("Erro ao Excluir");
			MensagemUtil.mensagemErro(MensagemUtil.Erro_Excluir);
		}
	}

	public void editar(Usuario usuedit) {
		this.usuario = usuedit;
	}

	public void salvar() {
		try {
			Usuario usuSalvo = usuarioService.salvar(usuario);

			if (usuario.getId() == null) {
				usuarioList.add(usuSalvo);
			}

			usuario = new Usuario();
			MensagemUtil.mensagemInfo(MensagemUtil.Salvo_Sucesso);
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro(MensagemUtil.Erro_Salvar);
			e.printStackTrace();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

}
