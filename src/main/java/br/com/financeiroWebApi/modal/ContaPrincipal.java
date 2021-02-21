package br.com.financeiroWebApi.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONTA_PRINCIPAL")
public class ContaPrincipal implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="cod_conta_principal")
	private Long id;
	
//	@Column(name="idUsuario_conta_principal",insertable = false,updatable = false)
//	private Long idUsuario;
//	
//	@Column(name="idConta_conta_principal",insertable = false,updatable = false)
//	private Long idConta;
		
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_conta_principal", referencedColumnName = "cod_conta_principal", nullable = false)
	private Usuario usuario;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_conta_principal", referencedColumnName = "cod_conta_principal", nullable = false)
	private Conta conta;
	
	public ContaPrincipal() {
		// TODO Auto-generated constructor stub
	}
	
	public ContaPrincipal(Usuario usuario, Conta conta) {
		this.usuario = usuario;
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getIdUsuario() {
//		return idUsuario;
//	}
//
//	public void setIdUsuario(Long idUsuario) {
//		this.idUsuario = idUsuario;
//	}
//
//	public Long getIdConta() {
//		return idConta;
//	}
//
//	public void setIdConta(Long idConta) {
//		this.idConta = idConta;
//	}

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
