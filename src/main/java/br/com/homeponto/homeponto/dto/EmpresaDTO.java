package br.com.homeponto.homeponto.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.homeponto.homeponto.model.Empresa;

public class EmpresaDTO {
	private String razaoSocial;
	private String nomeFantasia;
	
	public EmpresaDTO(Empresa empresa) {
		this.razaoSocial = empresa.getRazaoSocial();
		this.nomeFantasia = empresa.getNomeFantasia();
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public static List<EmpresaDTO> converter(List<Empresa> empresas) {
		List<EmpresaDTO> empresasDTO = new ArrayList<EmpresaDTO>();
		for(Empresa empresa: empresas) {
			empresasDTO.add(new EmpresaDTO(empresa));
		}
		return empresasDTO;
	}
	
	
	
	
}
