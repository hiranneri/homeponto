package br.com.homeponto.homeponto.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="marcacoes")
public class Marcacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalTime horario;
	private LocalDate data;
	@ManyToOne
	private Usuario usuario;
	
	public Marcacao (Long id, LocalTime horario, LocalDate data) {
		this.id = id;
		this.horario = horario;
		this.data = data;
	}
	
	public Marcacao() {
		
	}
	public Long getId() {
		return id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public LocalDate getData() {
		return data;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	

}
