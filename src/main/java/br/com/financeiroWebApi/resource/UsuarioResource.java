package br.com.financeiroWebApi.resource;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import br.com.financeiroWebApi.DTO.UsuarioDTO;
import br.com.financeiroWebApi.exception.NegociosException;
import br.com.financeiroWebApi.modal.Login;
import br.com.financeiroWebApi.modal.Usuario;
import br.com.financeiroWebApi.servico.LoginServico;
import br.com.financeiroWebApi.servico.UsuarioServico;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
	
	private static Logger log = Logger.getLogger(UsuarioResource.class.getName());

	@Inject
	private UsuarioServico servico;
	@Inject
	private LoginServico loginDao;
	
	@Context
	private UriInfo uriInfo; 
	
	@Path("/incluir")
	@POST
	public Response salvarUsuario(@Valid UsuarioDTO dto) {
		Usuario userSalvo = salvarLogin(dto);
			return Response.ok(userSalvo).build();
	}
	
	@Path("/find/{codigo}")
	@GET
	public Response findUsuario(@PathParam("codigo") Long codigo) throws NegociosException {
		if(servico.localizar(codigo).isPresent()) {
			Optional<Usuario> user = servico.localizar(codigo);
			return Response.ok(user.get()).build();
		}else {
			NegociosException msn =  new NegociosException("Usuário não localizado ");
			return Response.ok(msn.getMensagem()).build();
		}
		
	}
	
	@Path("/alterar")
	@POST
	public Response updateUsuario(@Valid UsuarioDTO dto) {
		Usuario userSalvo = salvarLogin(dto);
		if(userSalvo.equals(null)) {
			return Response.status(Status.OK).build();
		}
		return Response.ok(userSalvo).build();
	}
	
	@DELETE
	@Path("/excluir/{id}")
	public Response excluir(@PathParam("id") Long codigo) {
		if(servico.localizar(codigo).isPresent()) {
			servico.excluirUsuario(codigo);
			return Response.status(Response.Status.OK).build();
		}else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}
	
	@Path("/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuarios() {
		log.info("Obtendo lista de pessoas");
		Optional<List<Usuario>> listUsuario = servico.getList();
		return listUsuario.map(usuario -> Response.ok(usuario).build()).orElseGet(() -> Response.status(Status.NOT_FOUND).build());
	}
	
	public Usuario salvarLogin(UsuarioDTO dto) {
		Login login = new Login();
		Usuario user = new Usuario();
		
		try {
			user.setAtivos(dto.isAtivos());
			user.setCelular(dto.getCelular());
			user.setEmail(dto.getEmail());
			user.setNascimento(dto.getNascimento());
			user.setNome(dto.getNome());
			Usuario userSalvo =	servico.salvar(user);

			login.setUsuarioEmail(dto.getEmail());
			login.setUsuariSenha(dto.getSenha());
			login.setUsuario(userSalvo);
			loginDao.salvarLogin(login);
			
			return userSalvo;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			user = null;
			return user;
		}
		
	}
	
}
