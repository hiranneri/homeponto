package br.com.homeponto.controller.form;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;

import br.com.homeponto.model.Marcacao;
import br.com.homeponto.model.Perfil;

public class MarcacaoForm {
	
	@NotBlank
	private Long idEmpresa;
	
	@NotBlank
	private String nomeUsuario;
	
	
	
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	
	public Marcacao converterParaMarcacao(ZonedDateTime horario, Perfil perfil) {
		
		return new Marcacao(horario,perfil);
	}
	
	

}
