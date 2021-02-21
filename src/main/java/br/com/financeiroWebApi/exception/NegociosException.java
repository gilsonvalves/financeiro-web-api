package br.com.financeiroWebApi.exception;

public class NegociosException extends Exception {
	private static final long serialVersionUID = 1L;

	private String mensagem;

	public NegociosException(String s) {
		mensagem = s;
	}
	public String getMensagem() {
		return mensagem;
	}

}
