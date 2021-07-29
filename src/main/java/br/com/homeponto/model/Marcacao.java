package br.com.homeponto.model;


import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="marcacoes")
public class Marcacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "timestamptz") @NotNull
	private ZonedDateTime horario;
	
	@ManyToOne
	private Perfil usuario;
	
	public Marcacao() {
		
	}
	
	public Marcacao(ZonedDateTime horario, Perfil perfil) {
		this.horario = horario;
		this.usuario = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getHorario() {
		return horario;
	}

	public void setHorario(ZonedDateTime horario) {
		this.horario = horario;
	}

	public Perfil getUsuario() {
		return usuario;
	}

	public void setUsuario(Perfil usuario) {
		this.usuario = usuario;
	}
	
	
	

}
