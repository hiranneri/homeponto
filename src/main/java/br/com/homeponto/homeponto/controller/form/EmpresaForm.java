package br.com.homeponto.homeponto.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.homeponto.homeponto.model.Empresa;
import br.com.homeponto.homeponto.repository.EmpresaRepository;


public class EmpresaForm {
	
	@NotNull @NotEmpty @Length(min = 3, max = 300)
	private String nomeFantasia;
	@NotNull @NotEmpty @Length(min = 3, max = 300)
	private String razaoSocial;
	
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Empresa converter() {
		// TODO Auto-generated method stub
		return new Empresa(this);
	}
	//Altera o objeto do banco com os dados passados, quando o método finalizar,
	//será realizado o commit no bd
	public Empresa atualizar(Long id, EmpresaRepository empresaRepository) {
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
		Empresa empresa = null;
		if(optionalEmpresa.isPresent()) {
			empresa = optionalEmpresa.get();
			empresa.setNomeFantasia(this.nomeFantasia);
			empresa.setRazaoSocial(this.razaoSocial);
			
		}		
		
		return empresa;
		
	}
	
	
	
}
