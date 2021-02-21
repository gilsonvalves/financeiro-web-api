package br.com.financeiroWebApi.DTO;

import java.io.Serializable;
import java.util.Date;


public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	private String email;
	private String senha;
	private Date nascimento;
	private String celular;
	private boolean ativos;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public boolean isAtivos() {
		return ativos;
	}
	public void setAtivos(boolean ativos) {
		this.ativos = ativos;
	}

	
		

}
