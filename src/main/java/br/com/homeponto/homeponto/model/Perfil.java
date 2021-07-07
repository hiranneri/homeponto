package br.com.homeponto.homeponto.model;

public class Perfil {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private Cargo cargo; //FK
	
	public Perfil(String nome, String sobrenome, Cargo cargo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public Cargo getCargo() {
		return cargo;
	}
	
	
	

}
