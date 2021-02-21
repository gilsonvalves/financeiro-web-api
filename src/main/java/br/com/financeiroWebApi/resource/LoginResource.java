package br.com.financeiroWebApi.resource;

import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.financeiroWebApi.DTO.LoginDTO;
import br.com.financeiroWebApi.daos.ContaDao;
import br.com.financeiroWebApi.daos.LoginDao;
import br.com.financeiroWebApi.exception.NegociosException;
import br.com.financeiroWebApi.modal.Login;
import br.com.financeiroWebApi.modal.Usuario;
import br.com.financeiroWebApi.servico.LoginServico;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

	@Inject
	private LoginDao loginDao;
	@Inject
	private LoginServico servico;
	@Inject
	private ContaDao servicoLocalizarUsuario;
	
	@POST
	public Response salvar(@Valid Login login) {
		return Response.ok(servico.salvarLogin(login)).build();
	}
	
	@POST
	@Path("/autenticar")
	public Response autenticarUsuario(@Valid LoginDTO dtoUser) throws NegociosException {
	
		Optional<Usuario> usuarioLocalizado = validarUsuario(dtoUser);
	
		if(usuarioLocalizado.isEmpty()) {
		//	NegociosException msn =  new NegociosException("Usuário não localizado ");
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(usuarioLocalizado.get().getCodigo()).build();
		
	}

	private Optional<Usuario> validarUsuario(LoginDTO dtoUser) {
		Optional<Usuario> usuarioRetorno = Optional.empty();
		
		Optional<Login> loginLocalizado = loginDao.buscarUsuarioPorEmail(dtoUser.getUsuarioEmail(), dtoUser.getUsuarioSenha());
		
		if(!loginLocalizado.equals(null)) {
			Long x = loginLocalizado.get().getUsuario().getCodigo();
			usuarioRetorno = servicoLocalizarUsuario.obterPorId(x);
			if(usuarioRetorno.get().equals(null) || loginLocalizado.get().equals(null)) {
				new NegociosException("Usuario nao encontrado");
				return Optional.empty();	
				}
			if(loginLocalizado.get().getUsuarioEmail().equals(dtoUser.getUsuarioEmail()) && 
					loginLocalizado.get().getUsuariSenha().equals(dtoUser.getUsuarioSenha())) {
			return usuarioRetorno;
			}
		}
			return Optional.empty();
	}
}
