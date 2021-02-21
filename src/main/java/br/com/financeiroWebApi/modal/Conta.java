package br.com.financeiroWebApi.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_CONTA")
public class Conta implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="cod_conta")
	private Long conta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_usuario",referencedColumnName = "cod_usuario" ,nullable = false)
	private Usuario usuario;
	
	@Column(name="desc_conta")
	private String descricao;
	
	@Column(nullable= false,name="dataCads_conta", updatable= false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataCadastro;
	
	@Column(name="saldo_conta")
	private float saldo;
	
	@Column(name="fav_conta")
	private boolean favorita;

	public Conta() {
	}
	
	public Conta(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getConta() {
		return conta;
	}

	public void setConta(Long conta) {
		this.conta = conta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isFavorita() {
		return favorita;
	}

	public void setFavorita(boolean favorita) {
		this.favorita = favorita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
