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
@Table(name = "TB_CATEGORIA")
public class Categoria implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="cod_categoria")
	private Long codigo;
	
	@OneToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "cod_categoria", referencedColumnName = "cod_categoria", nullable = false)
	private Usuario usuario; //codigo
	
	@Column(name="pai_categoria")
	private int categoria_Pai;//codigo 1 2
	
	@Column(name="tipo_categoria")
	private String tipo; //1 despesa 2 receita
	
	@Column(name="desc_categoria")
	private String descricao; //
	
	@Column(name="fator_categoria")
	private int fator;
	
	public Categoria() {
	}

	public Categoria(Long codigo, int categoria_Pai, Usuario usuario, String tipo, String descricao, int fator) {
		this.codigo = codigo;
		this.categoria_Pai = categoria_Pai;
		this.usuario = usuario;
		this.tipo = tipo;
		this.descricao = descricao;
		this.fator = fator;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCategoria_Pai() {
		return categoria_Pai;
	}

	public void setCategoria_Pai(int categoria_Pai) {
		this.categoria_Pai = categoria_Pai;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getFator() {
		return fator;
	}

	public void setFator(int fator) {
		this.fator = fator;
	}
	
}