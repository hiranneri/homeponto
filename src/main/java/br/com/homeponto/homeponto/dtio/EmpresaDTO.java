package br.com.homeponto.homeponto.dtio;

import br.com.homeponto.homeponto.model.Empresa;

public class EmpresaDTO {
	private String razaoSocial;
	private String nomeFantasia;
	
	public EmpresaDTO(Empresa empresa) {
		this.razaoSocial = empresa.getRazaoSocial();
		this.nomeFantasia = empresa.getNomeFantasia();
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	
	
	
}
