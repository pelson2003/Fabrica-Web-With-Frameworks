package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.entidade.Perfil;
import br.com.fabricadeprogramador.service.PerfilService;
import br.com.fabricadeprogramador.service.ServiceException;

// @ManagedBean (name="usuCtrl")// Mundo do JSF

@Controller(value = "perfilCtrl") // Mundo do Spring
// @ManagedBean(name = "usuCtrl")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;

	private Perfil perfil = new Perfil();
	private List<Perfil> perfilList;

	public PerfilController() {
	}

	@PostConstruct
	public void init() {
		setPerfilList(perfilService.buscarTodos());
	}

	public void excluir(Perfil perfil) {
		try {
			perfilService.excluir(perfil);
			perfilList.remove(perfil);

			// MensagemUtil.mensagemInfo("Excluido com Sucesso");
			MensagemUtil.mensagemInfo(MensagemUtil.Excluido_Sucesso);

		} catch (ServiceException e) {
			//MensagemUtil.mensagemErro("Erro ao Excluir");
			MensagemUtil.mensagemErro(MensagemUtil.Erro_Excluir);
		}
	}

	public void editar(Perfil usuedit) {
		this.perfil = usuedit;
	}

	public void salvar() {
		try {
			Perfil usuSalvo = perfilService.salvar(perfil);

			if (perfil.getId() == null) {
				perfilList.add(usuSalvo);
			}

			perfil = new Perfil();
			MensagemUtil.mensagemInfo(MensagemUtil.Salvo_Sucesso);
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro(MensagemUtil.Erro_Salvar);
			e.printStackTrace();
		}
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfilList() {
		return perfilList;
	}

	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
	}

}
