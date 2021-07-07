package br.com.homeponto.homeponto.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Marcacao {
	
	private Long id;
	private LocalTime horario;
	private LocalDate data;
	private Usuario usuario;
	
	public Marcacao (Long id, LocalTime horario, LocalDate data) {
		this.id = id;
		this.horario = horario;
		this.data = data;
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
