package br.com.homeponto.erros;

public class EmpresaNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmpresaNotFoundException(String message) {
		super(message);
	}

}
