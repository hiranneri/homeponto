package br.com.homeponto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AtualizacaoPerfilForm {

	@NotNull @NotEmpty @Length(min = 3, max = 100)
	private String nome;
	@NotNull @NotEmpty @Length(min = 2, max = 200)
	private String sobrenome;
	@NotNull @NotEmpty @Length(min = 3, max = 100)
	private String cargo;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
