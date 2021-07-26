package br.com.homeponto.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

import br.com.homeponto.controller.form.PerfilForm;
import br.com.homeponto.erros.PerfilNotFoundException;
import br.com.homeponto.repository.PerfilRepository;

@Entity
@Table(name="perfis")
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true) @NotNull
	private String nome;
	
	@NotNull
	private String sobrenome;
	
	@OneToOne(cascade = CascadeType.PERSIST) @NotNull
	private Cargo cargo; 
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Horario horario;
	
	public Perfil(String nome, String sobrenome, Cargo cargo, Horario horario) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
		this.horario = 	horario;
	}
	
	public Perfil() {
		
	}
	
	public Perfil(PerfilForm perfilForm, Cargo cargo, Horario horario) {
		this.nome = perfilForm.getNome();
		this.sobrenome = perfilForm.getSobrenome();
		this.cargo = cargo;
		this.horario = horario;
		
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
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public static Perfil pesquisarPerfilPorID(Long idEmpresa, Long idPerfil,
			PerfilRepository perfilRepository) {
		Perfil perfil = perfilRepository.findById(idPerfil).orElseThrow(()-> 
			new PerfilNotFoundException("Perfil não localizado"));
		return perfil;
	}

	@Override
	public String getAuthority() {
		return this.cargo.getNome();
	}
	
	
	

}
