package br.com.homeponto.homeponto.model;

public class Usuario {

	private Long id;
	private String login;
	private String senha;
	private Empresa empresa; //FK
	private Perfil perfil; //FK
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}
	
	public Empresa getEmpresa() {
		return this.empresa;
	}


	
	
	
	
}
