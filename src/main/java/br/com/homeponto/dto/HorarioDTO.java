package br.com.homeponto.dto;

import java.time.LocalTime;

import br.com.homeponto.model.Horario;

public class HorarioDTO {
	
	private LocalTime horarioEntrada;
	private LocalTime horarioSaida;
	private LocalTime horarioRetorno;
	private LocalTime horarioFinal;
	
	public HorarioDTO(Horario horario) {
		this.horarioEntrada = horario.getHorarioEntrada();
		this.horarioSaida = horario.getHorarioSaida();
		this.horarioRetorno = horario.getHorarioRetorno();
		this.horarioFinal = horario.getHorarioFinal();
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
