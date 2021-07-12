package br.com.homeponto.homeponto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.homeponto.homeponto.controller.form.EmpresaForm;

@Entity
@Table(name="empresas")
public class Empresa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razaoSocial;
	private String nomeFantasia;
	
	public Empresa() {
		
	}
	
	public Empresa(EmpresaForm empresaForm) {
		this.razaoSocial = empresaForm.getRazaoSocial();
		this.nomeFantasia = empresaForm.getNomeFantasia();
	}
	
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

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	
	
	
	
}
