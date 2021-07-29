package br.com.homeponto.dto;

import java.time.format.DateTimeFormatter;

import br.com.homeponto.model.Empresa;
import br.com.homeponto.model.Marcacao;

public class MarcacaoDTO {

	private String empresa;
	private String nomeUsuario;
	private String cargo;
	private String horario;
	
	public MarcacaoDTO(Marcacao marcacao, Empresa empresa) {
		this.empresa = empresa.getNomeFantasia();
		this.nomeUsuario = marcacao.getUsuario().getNome();
		this.cargo = marcacao.getUsuario().getCargo().getNome();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss Z");
		this.horario = marcacao.getHorario().format(dtf);
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getCargo() {
		return cargo;
	}

	public String getHorario() {
		return horario;
	}

	
}
