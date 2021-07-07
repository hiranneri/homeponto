package br.com.homeponto.homeponto.model;

public class Empresa {

	private Long id;
	private String razaoSocial;
	private String nomeFantasia;
	
	public Empresa(String razaoSocial, String nomeFantasia) {
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}

	public Long getId() {
		return id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	
	
}
