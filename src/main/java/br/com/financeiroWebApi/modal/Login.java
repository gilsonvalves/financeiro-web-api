package br.com.financeiroWebApi.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_LOGIN")
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long codigoLogin;
	@NotNull
	@Column(name = "usuario_email")
	private String usuarioEmail;
	@NotNull
	@Column(name = "usuario_senha")
	private String usuariSenha;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cod_usuario",referencedColumnName = "cod_usuario" ,nullable = false)
	private Usuario usuario;
	
	public Login() {
	}
	public Login(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getCodigoLogin() {
		return codigoLogin;
	}
	public void setCodigoLogin(Long codigoLogin) {
		this.codigoLogin = codigoLogin;
	}
	public String getUsuarioEmail() {
		return usuarioEmail;
	}
	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}
	public String getUsuariSenha() {
		return usuariSenha;
	}
	public void setUsuariSenha(String usuariSenha) {
		this.usuariSenha = usuariSenha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
