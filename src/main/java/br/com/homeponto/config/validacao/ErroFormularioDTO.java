package br.com.homeponto.config.validacao;

public class ErroFormularioDTO {
	
	private String campo;
	private String mensagem;
	
	public ErroFormularioDTO (String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	

}
