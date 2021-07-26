package br.com.homeponto.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.homeponto.config.security.TokenService;
import br.com.homeponto.dto.TokenDTO;
import br.com.homeponto.controller.form.EmpresaForm;
import br.com.homeponto.controller.form.LoginForm;
import br.com.homeponto.controller.form.PerfilForm;
import br.com.homeponto.erros.EmpresaNotFoundException;
import br.com.homeponto.erros.PerfilNotFoundException;
import br.com.homeponto.model.Usuario;
import br.com.homeponto.repository.EmpresaRepository;
import br.com.homeponto.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/empresa/{idEmpresa}/login")
public class UsuarioController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication =  authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
			
		}catch(AuthenticationException err) {
			return ResponseEntity.notFound().build();
		}
	}

	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> desativarUsuario(@PathVariable Long idEmpresa, 
			@RequestBody @Valid PerfilForm perfilForm) {
		try {
			EmpresaForm.pesquisarEmpresaPorID(idEmpresa, empresaRepository);
			Usuario usuario = usuarioRepository.findByLogin(perfilForm.getLogin()).get();
			usuario.setAtivo(false);
			return ResponseEntity.ok().build();
		}catch(EmpresaNotFoundException | PerfilNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}
