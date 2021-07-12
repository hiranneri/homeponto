package br.com.homeponto.homeponto.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="perfis")
public class Perfil {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenome;
	@Enumerated(EnumType.STRING)
	private Cargo cargo; 
	
	public Perfil(String nome, String sobrenome, Cargo cargo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
	}
	
	public Perfil() {
		
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
