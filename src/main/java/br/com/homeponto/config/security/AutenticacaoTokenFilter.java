package br.com.homeponto.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.homeponto.erros.UsuarioNotFoundException;
import br.com.homeponto.model.Usuario;
import br.com.homeponto.repository.UsuarioRepository;

public class AutenticacaoTokenFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;
	
	public AutenticacaoTokenFilter(TokenService tokenService, UsuarioRepository usuario) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuario;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if(valido) {
			autenticarCliente(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticarCliente(String token) {
		try {
			Long idUsuario = tokenService.getIdUsuario(token);
			Usuario usuario = usuarioRepository.findById(idUsuario).get();
			UsernamePasswordAuthenticationToken authentication = 
					new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}catch(UsuarioNotFoundException ex) {
			
		}
	}
	
	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token==null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;			
		}
		return token.substring(7,token.length());
	}

}
