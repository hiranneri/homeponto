package br.com.homeponto.erros;

public class PerfilNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public PerfilNotFoundException(String message) {
		super(message);
	}
}
