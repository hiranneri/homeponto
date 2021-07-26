package br.com.homeponto.model;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="horarios")
public class Horario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private LocalTime horarioEntrada;
	
	@NotNull
	private LocalTime horarioSaida;
	
	@NotNull
	private LocalTime horarioRetorno;
	
	@NotNull
	private LocalTime horarioFinal;
	
	public Horario() {
		
	}
	
	public Horario(LocalTime horarioEntrada,LocalTime horarioSaida, LocalTime horarioRetorno, 
			LocalTime horarioFinal) {
		
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.horarioRetorno = horarioSaida;
		this.horarioFinal = horarioFinal;
		
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
	
	

}
