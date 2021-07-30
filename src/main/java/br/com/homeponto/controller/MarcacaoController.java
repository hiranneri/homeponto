package br.com.homeponto.controller;

import java.net.URI;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.homeponto.controller.form.EmpresaForm;
import br.com.homeponto.controller.form.MarcacaoForm;
import br.com.homeponto.dto.MarcacaoDTO;
import br.com.homeponto.erros.EmpresaNotFoundException;
import br.com.homeponto.erros.PerfilNotFoundException;
import br.com.homeponto.model.Empresa;
import br.com.homeponto.model.Marcacao;
import br.com.homeponto.model.Perfil;
import br.com.homeponto.repository.EmpresaRepository;
import br.com.homeponto.repository.MarcacaoRepository;
import br.com.homeponto.repository.PerfilRepository;

@RestController
@RequestMapping("/api/usuario/{idPerfil}/marcacao")
public class MarcacaoController {
	
	@Autowired
	private MarcacaoRepository marcacaoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<MarcacaoDTO> marcarPonto(@RequestBody @Valid MarcacaoForm marcacaoForm, 
			@PathVariable Long idPerfil, UriComponentsBuilder uriBuilder) {
		try {
			Empresa empresa = validarEmpresa(marcacaoForm.getIdEmpresa());
			Perfil perfil = validarPerfil(idPerfil);		
			ZonedDateTime horario = gerarHorario(perfil);
			Marcacao marcacao = marcacaoForm.converterParaMarcacao(horario,perfil);
			marcacaoRepository.save(marcacao);
			
			URI uri = uriBuilder.path("/api/usuario/"+perfil.getId()+"/marcacao/{id}")
					.buildAndExpand(marcacao.getId()).toUri();
			
			return ResponseEntity.created(uri).body(new MarcacaoDTO(marcacao,empresa));
		}catch(EmpresaNotFoundException | PerfilNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	private ZonedDateTime gerarHorario(Perfil perfil) {
		ZoneId zona = ZoneId.of(perfil.getFuso());
		ZonedDateTime horarioAgora = ZonedDateTime.now(zona);
		return horarioAgora;		 
	}
	private Empresa validarEmpresa(Long idEmpresa) {
		Empresa empresa = EmpresaForm.pesquisarEmpresaPorID(idEmpresa, empresaRepository);
		return empresa;
	}
	private Perfil validarPerfil(Long idPerfil) {
		Perfil perfil = Perfil.pesquisarPerfilPorID(idPerfil, perfilRepository);
		return perfil;
	}
	

}
