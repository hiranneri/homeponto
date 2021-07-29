package br.com.homeponto.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.homeponto.controller.form.AtualizacaoPerfilForm;
import br.com.homeponto.controller.form.EmpresaForm;
import br.com.homeponto.controller.form.PerfilForm;
import br.com.homeponto.dto.PerfilDTO;
import br.com.homeponto.erros.EmpresaNotFoundException;
import br.com.homeponto.erros.PerfilNotFoundException;
import br.com.homeponto.model.Cargo;
import br.com.homeponto.model.Empresa;
import br.com.homeponto.model.Perfil;
import br.com.homeponto.model.Usuario;
import br.com.homeponto.repository.EmpresaRepository;
import br.com.homeponto.repository.PerfilRepository;
import br.com.homeponto.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/empresa/{idEmpresa}/perfil")
public class PerfilController {

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<PerfilDTO> lista(String nome){
		List<Perfil> perfis;
		if(nome==null) {
			perfis = perfilRepository.findAll();
		}else {
			perfis =  perfilRepository.getByNome(nome);			
		}
		return PerfilDTO.converterPerfis(perfis);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PerfilDTO> listarPorID(@PathVariable Long id, 
			@PathVariable Long idEmpresa) {
		try {
			EmpresaForm.pesquisarEmpresaPorID(idEmpresa, empresaRepository);
			Perfil perfil = Perfil.pesquisarPerfilPorID(id, perfilRepository);
			return ResponseEntity.ok(new PerfilDTO(perfil));	
			
		}catch(EmpresaNotFoundException | PerfilNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PerfilDTO> cadastrar(@RequestBody @Valid PerfilForm perfilForm,
			@PathVariable Long idEmpresa, UriComponentsBuilder uriBuilder) {
		try {
			Empresa empresa = EmpresaForm.pesquisarEmpresaPorID(idEmpresa, 
					empresaRepository);
			
			Perfil perfil = perfilForm.converterParaPerfil();
			
			perfilRepository.save(perfil);
			
			List<Perfil> perfis = new ArrayList<Perfil>();
			perfis.add(perfil);
			
			Usuario usuario = perfilForm.converterParaUsuario(empresa,perfis);
			usuarioRepository.save(usuario);
			
			URI uri = uriBuilder.path("empresas/"+empresa.getId()+"/perfil/{id}")
					.buildAndExpand(perfil.getId()).toUri();
			return ResponseEntity.created(uri).body(new PerfilDTO(perfil));
		}catch(EmpresaNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PerfilDTO> atualizar(@RequestBody @Valid AtualizacaoPerfilForm perfilForm, 
			@PathVariable Long idEmpresa, @PathVariable Long id) {
		try {
			EmpresaForm.pesquisarEmpresaPorID(idEmpresa, empresaRepository);
			Perfil perfil = Perfil.pesquisarPerfilPorID(id, perfilRepository);
			perfil.setNome(perfilForm.getNome());
			perfil.setSobrenome(perfilForm.getSobrenome());
			perfil.setCargo(new Cargo(perfilForm.getCargo()));
			
			return ResponseEntity.ok(new PerfilDTO(perfil));
			
		}catch(EmpresaNotFoundException | PerfilNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}	
		
	}
	
	
}
