package br.com.homeponto.homeponto.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="horarios")
public class Horarios {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalTime horarioEntrada;
	private LocalTime horarioSaida;
	private LocalTime horarioRetorno;
	private LocalTime horarioFinal;
	
	@OneToOne
	private Usuario usuario; //FK
	
	public Horarios() {
		
	}
	
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
