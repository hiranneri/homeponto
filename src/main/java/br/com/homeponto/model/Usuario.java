package br.com.homeponto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sun.istack.NotNull;

import br.com.homeponto.controller.form.PerfilForm;
import br.com.homeponto.erros.UsuarioNotFoundException;
import br.com.homeponto.repository.UsuarioRepository;

@Entity
@Table(name="usuarios")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @Column(unique = true)
	private String login;
	
	@NotNull
	private String senha;
	
	@NotNull @OneToOne
	private Empresa empresa; //FK
	
	@OneToMany(mappedBy = "usuario")
	private List<Marcacao> marcacao = new ArrayList<>();
	
	@NotNull @Column(name="ativo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
	private boolean ativo = true;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<Perfil>();
	
	public Usuario () {
		
	}
	public Usuario(PerfilForm perfilForm, Empresa empresa, List<Perfil> perfis) {
		this.login = perfilForm.getLogin();
		this.senha = perfilForm.getSenha();
		this.empresa = empresa;
		this.perfis = perfis;
	}
	

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}
	public Empresa getEmpresa() {
		return this.empresa;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public static Usuario pesquisarUsuarioPorID(Long idEmpresa, Long idUsuario, 
			UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(()-> 
		new UsuarioNotFoundException("Perfil não localizado"));
		return usuario;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.perfis;
	}
	@Override
	public String getPassword() {		
		return this.senha;
	}
	@Override
	public String getUsername() {		
		return this.login;
	}
	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}
	@Override
	public boolean isEnabled() {		
		return this.ativo;
	}
	
	
	
	
	
	
}
