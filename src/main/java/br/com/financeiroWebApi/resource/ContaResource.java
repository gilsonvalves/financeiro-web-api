package br.com.financeiroWebApi.resource;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.financeiroWebApi.DTO.ContaDTO;
import br.com.financeiroWebApi.daos.ContaDao;
import br.com.financeiroWebApi.daos.UsuarioDAO;
import br.com.financeiroWebApi.exception.NegociosException;
import br.com.financeiroWebApi.modal.Conta;
import br.com.financeiroWebApi.modal.Usuario;
import br.com.financeiroWebApi.servico.ContaServico;

@Path("conta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContaResource {

	@Inject
	private ContaServico servicoConta;
	
	@Inject
	private ContaDao servicoContaDAO;
	
	@POST
	public Response salvarConta(@Valid ContaDTO dto) {
		try {
			Conta entidade = converter(dto);
			entidade = servicoConta.salvarConta(entidade);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("{conta}")
	public Response excluirConta(@PathParam("conta") Long conta) {
		if(servicoConta.carregar(conta).isPresent()) {
			servicoConta.excluirConta(conta);
			return Response.status(Response.Status.OK).build();
		}else {
			return Response.status(Response.Status.NOT_FOUND).build();
		} 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarContas() {
		Optional<List<Conta>> listaConta = servicoConta.listarConta();
		return listaConta.map(conta -> Response.ok(conta).build()).orElseGet(() -> Response.status(Status.NOT_FOUND).build());
	}
	
	@PUT
	public Response atualizarConta(@Valid Conta conta) {
		if(servicoConta.carregar(conta.getConta()).isPresent()) {
			return Response.ok(servicoConta.atualizarConta(conta)).build();
		}else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	
	private Conta converter(ContaDTO dto) {
		Conta conta = new Conta();
		//conta.setConta(dto.getConta());
		conta.setDataCadastro(dto.getDataCadastro());
		conta.setDescricao(dto.getDescricao());
		conta.setFavorita(dto.isFavorita());
		conta.setSaldo(dto.getSaldo());
		Long x = dto.getUsuario();
		Optional<Usuario> usuario = servicoContaDAO.obterPorId(x);// .orElseThrow( () -> new RegraNegocioException("Usuario nao encontrado"));
		if(usuario.get().equals(null)) {
			new NegociosException("Usuario nao encontrado");
		}
		conta.setUsuario(usuario.get());
		return conta;
	}
}



