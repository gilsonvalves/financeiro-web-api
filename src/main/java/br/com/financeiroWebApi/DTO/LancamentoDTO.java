package br.com.financeiroWebApi.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LancamentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long lancamento;
	private Date data;
	private String descricao;
	private BigDecimal valor;
	
	private Long conta;
	private Long usuario;
	
	
	public Long getLancamento() {
		return lancamento;
	}
	public void setLancamento(Long lancamento) {
		this.lancamento = lancamento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Long getConta() {
		return conta;
	}
	public void setConta(Long conta) {
		this.conta = conta;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
}
