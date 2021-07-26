package br.com.homeponto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.homeponto.controller.form.EmpresaForm;
import br.com.homeponto.dto.EmpresaDTO;
import br.com.homeponto.model.Empresa;
import br.com.homeponto.repository.EmpresaRepository;

@RestController
@RequestMapping("/api/empresa/")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	@GetMapping
	public List<EmpresaDTO> lista(String nomeEmpresa) {
		if(nomeEmpresa==null) {
			List<Empresa> empresas = empresaRepository.findAll();
			return EmpresaDTO.converter(empresas);
			
		}else {
			List<Empresa> empresas = empresaRepository.findByNomeFantasia(nomeEmpresa);
			return EmpresaDTO.converter(empresas);
		}
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<EmpresaDTO> cadastrar(@RequestBody @Valid EmpresaForm empresaForm, 
			UriComponentsBuilder uriBuilder) {
		Empresa empresa = empresaForm.converter();
		empresaRepository.save(empresa);
		
		URI uri = uriBuilder.path("/api/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
		return ResponseEntity.created(uri).body(new EmpresaDTO(empresa));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EmpresaDTO> atualizar(@PathVariable Long id, 
			@RequestBody @Valid EmpresaForm empresaForm){
		Empresa empresa = empresaForm.atualizar(id, empresaRepository);
		if(empresa != null) {
			return ResponseEntity.ok(new EmpresaDTO(empresa));			
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Empresa> optional = empresaRepository.findById(id);
		if(optional.isPresent()) {
			empresaRepository.deleteById(id);
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build(); 
	}
}
