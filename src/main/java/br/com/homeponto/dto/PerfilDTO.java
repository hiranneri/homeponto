package br.com.homeponto.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.homeponto.model.Perfil;

public class PerfilDTO {
	
	private String nome;
	private String sobrenome;
	private String cargo;
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getCargo() {
		return cargo;
	}
	
	public PerfilDTO(Perfil perfil) {
		this.nome = perfil.getNome();
		this.sobrenome = perfil.getSobrenome();
		this.cargo = perfil.getCargo().getNome();
	}
	
	public static List<PerfilDTO> converterPerfis(List<Perfil> perfis){
		List<PerfilDTO> perfisDTO = new ArrayList<>();
		for(Perfil perfil: perfis) {
			perfisDTO.add(new PerfilDTO(perfil));
		}
		return perfisDTO;
	}
	

}
