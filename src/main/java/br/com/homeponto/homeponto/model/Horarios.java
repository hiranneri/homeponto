package br.com.homeponto.homeponto.model;

import java.time.LocalTime;

public class Horarios {
	
	private Long id;
	private LocalTime horarioEntrada;
	private LocalTime horarioSaida;
	private LocalTime horarioRetorno;
	private LocalTime horarioFinal;	
	private Usuario usuario;
	
	public Horarios(LocalTime horarioEntrada,LocalTime horarioSaida, LocalTime horarioRetorno, 
			LocalTime horarioFinal, Usuario usuario) {
		
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.horarioRetorno = horarioSaida;
		this.horarioFinal = horarioFinal;
		this.usuario = usuario;		
	}

	public Long getId() {
		return id;
	}

	public LocalTime getHorarioEntrada() {
		return horarioEntrada;
	}

	public LocalTime getHorarioSaida() {
		return horarioSaida;
	}

	public LocalTime getHorarioRetorno() {
		return horarioRetorno;
	}

	public LocalTime getHorarioFinal() {
		return horarioFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	

}
