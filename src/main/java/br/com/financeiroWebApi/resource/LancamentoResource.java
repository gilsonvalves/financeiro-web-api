package br.com.financeiroWebApi.resource;

import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.financeiroWebApi.DTO.LancamentoDTO;
import br.com.financeiroWebApi.daos.ContaDao;
import br.com.financeiroWebApi.exception.NegociosException;
import br.com.financeiroWebApi.modal.Conta;
import br.com.financeiroWebApi.modal.Lancamento;
import br.com.financeiroWebApi.modal.Usuario;
import br.com.financeiroWebApi.servico.LancamentoServico;


@Path("lancamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LancamentoResource {
	
	@Inject
	private LancamentoServico servico;
	
	@Inject
	private ContaDao servicoContaDAO;
	
	@Context
	private UriInfo uriInfo; 
	
    @POST
	public Response salvarLancamento(@Valid LancamentoDTO dto) {
		try {
			Lancamento lacamentoSalvar = converter(dto);
			lacamentoSalvar = servico.salvar(lacamentoSalvar);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	private Lancamento converter(LancamentoDTO dto) {
		Long idUsuario = dto.getUsuario();
		Long idConta = dto.getConta();

		Lancamento lancamento = new Lancamento();
	
		Optional<Usuario> usuario = servicoContaDAO.obterPorId(idUsuario);
		if(usuario.get().equals(null)) {
			new NegociosException("Usuario nao encontrado");
		}
		Optional<Conta> conta = servicoContaDAO.obterPorIdConta(idConta);
		if(conta.get().equals(null)) {
			new NegociosException("Conta nao encontrado");
		}
			lancamento.setUsuario(usuario.get());
			lancamento.setConta(conta.get());
			lancamento.setData(dto.getData());
			lancamento.setDescricao(dto.getDescricao());
			lancamento.setValor(dto.getValor());
			
		return lancamento;
	}

}
