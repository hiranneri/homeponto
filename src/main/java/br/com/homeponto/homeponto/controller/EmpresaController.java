package br.com.homeponto.homeponto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.homeponto.homeponto.dtio.EmpresaDTO;
import br.com.homeponto.homeponto.model.Empresa;

@RestController
public class EmpresaController {
	
	@RequestMapping("/empresas")
	public List<EmpresaDTO> lista() {
		EmpresaDTO empresaDTO;
		List<EmpresaDTO> empresas = new ArrayList<EmpresaDTO>();
		for(Integer i=0;i<5;i++) {
			empresaDTO = new EmpresaDTO(new Empresa("Escribe0"+i.toString(),"Escriba 0"+ i.toString()));
			empresas.add(empresaDTO);
		}
		return empresas;
	}
}
