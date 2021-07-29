package br.com.homeponto.controller.form;

import java.time.LocalTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import br.com.homeponto.model.Cargo;
import br.com.homeponto.model.Empresa;
import br.com.homeponto.model.Horario;
import br.com.homeponto.model.Perfil;
import br.com.homeponto.model.Usuario;

public class PerfilForm {
	
	@NotNull @NotEmpty @Length(min = 3, max = 100)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 2, max = 200)
	private String sobrenome;
	
	@NotNull @NotEmpty @Length(min = 3, max = 100)
	private String cargo;
	
	@NotNull @NotEmpty @Length(min = 3, max = 50)
	private String login;
	
	@NotNull @NotEmpty @Length(min = 3, max = 50)
	private String senha;
	
	@PastOrPresent 
	private LocalTime horarioEntrada;
	
	@PastOrPresent 
	private LocalTime horarioSaida;
	
	@PastOrPresent 
	private LocalTime horarioRetorno;
	
	@PastOrPresent 
	private LocalTime horarioFinal;
	
	@NotNull @NotEmpty @Length(min = 3, max = 150)
	private String fuso;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public LocalTime getHorarioEntrada() {
		return horarioEntrada;
	}
	public void setHorarioEntrada(LocalTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}
	public LocalTime getHorarioSaida() {
		return horarioSaida;
	}
	public void setHorarioSaida(LocalTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	public LocalTime getHorarioRetorno() {
		return horarioRetorno;
	}
	public void setHorarioRetorno(LocalTime horarioRetorno) {
		this.horarioRetorno = horarioRetorno;
	}
	public LocalTime getHorarioFinal() {
		return horarioFinal;
	}
	public void setHorarioFinal(LocalTime horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	
	public String getFuso() {
		return fuso;
	}
	public void setFuso(String fuso) {
		this.fuso = fuso;
	}
	public Perfil converterParaPerfil() {
		Cargo cargo = new Cargo(this.cargo);
		Horario horario = new Horario(horarioEntrada, horarioSaida, horarioRetorno, horarioFinal);
		return new Perfil(this, cargo, horario);
	}
	
	private String hashSenha(String senha) {
		this.passwordEncoder = new BCryptPasswordEncoder();
		String senhaHashed = this.passwordEncoder.encode(senha);
		return senhaHashed;
	}
	
	public Usuario converterParaUsuario(Empresa empresa, List<Perfil> perfil) {
		Usuario usuario = new Usuario(this,empresa,perfil);
		usuario.setSenha(hashSenha(usuario.getSenha()));
		return usuario;
	}	
	

}
