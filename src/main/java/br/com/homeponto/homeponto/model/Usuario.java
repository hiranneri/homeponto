package br.com.homeponto.homeponto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	@OneToOne
	private Empresa empresa; //FK
	
	@OneToOne
	private Perfil perfil; //FK
	
	@OneToMany(mappedBy = "usuario")
	private List<Marcacao> marcacao = new ArrayList<>();
	
	public Usuario () {
		
	}
	
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
