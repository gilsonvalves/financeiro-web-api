package br.com.financeiroWebApi.resource;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.financeiroWebApi.DTO.ContaPrincipalDTO;
import br.com.financeiroWebApi.modal.Conta;
import br.com.financeiroWebApi.modal.ContaPrincipal;
import br.com.financeiroWebApi.modal.Usuario;
import br.com.financeiroWebApi.servico.ContaPrincipalServico;
import br.com.financeiroWebApi.servico.ContaServico;
import br.com.financeiroWebApi.servico.UsuarioServico;

@Path("usuario/principal_conta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContaPrincipalResource {
	
	@Inject
	private ContaPrincipalServico servicoContaPrincipal;
	@Inject
	private UsuarioServico usuarioServico;
	@Inject
	private ContaServico contaServico;

	@POST
	public Response salvarContaPrincipal(@Valid ContaPrincipalDTO dto) {
		try {
			/** 
			 * aki vou receber dto 
			 * 
			 */
			ContaPrincipal contaSalvar = salvarEntidade(dto);
			servicoContaPrincipal.salvarConta(contaSalvar);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	private Response listarContaPrincipal() {
		Optional<List<ContaPrincipal>> listarContaPrincipal =servicoContaPrincipal.listaContaPrincipal();
		return listarContaPrincipal.map(contaPrincipal -> Response.ok(contaPrincipal).build()).orElseGet(() -> Response.status(Status.NOT_FOUND).build());

	}
	
	
	private ContaPrincipal salvarEntidade(ContaPrincipalDTO dto) {
		ContaPrincipal contaPrincipal = new ContaPrincipal();
		Usuario usuarioSalvo = usuarioServico.salvar(dto.getUsuario());
		//Categoria cat = catServico.salvarEstruraPadrao(usuarioSalvo);
		
		Conta conta = new Conta();
		//conta.setConta(dto.getConta());
		conta.setDataCadastro(dto.getConta().getDataCadastro());
		conta.setDescricao(dto.getConta().getDescricao());
		conta.setFavorita(dto.getConta().isFavorita());
		conta.setSaldo(dto.getConta().getSaldo());
		conta.setUsuario(usuarioSalvo);
		Conta contaSalvo = contaServico.salvarConta(conta);
		contaPrincipal.setConta(contaSalvo);
		contaPrincipal.setUsuario(usuarioSalvo);
		
		return contaPrincipal;
	}
}
