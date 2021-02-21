package br.com.financeiroWebApi.DTO;

import java.io.Serializable;

import br.com.financeiroWebApi.modal.Conta;
import br.com.financeiroWebApi.modal.Usuario;

public class ContaPrincipalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Usuario usuario;
	
	private Conta conta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
