package br.com.homeponto.controller;

import br.com.homeponto.controller.form.MarcacaoForm;
import br.com.homeponto.dto.MarcacaoDTO;
import br.com.homeponto.dto.MarcacaoResponseDTO;
import br.com.homeponto.service.MarcacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/marcacao")
public class MarcacaoController {
	@Autowired
	MarcacaoService marcacaoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<MarcacaoResponseDTO> marcarPonto(@RequestBody @Valid MarcacaoForm marcacaoForm,
														   @PathVariable Long idPerfil, UriComponentsBuilder uriBuilder) {
		return new ResponseEntity<>(marcacaoService.marcarPonto(marcacaoForm), HttpStatus.CREATED);
	}

}
