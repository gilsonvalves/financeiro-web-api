package br.com.financeiroWebApi.servico;

import java.io.Serializable;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.financeiroWebApi.daos.LancamentoDao;
import br.com.financeiroWebApi.modal.Lancamento;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class LancamentoServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LancamentoDao dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Lancamento salvar(@Valid Lancamento entity) {
		return dao.salvar(entity);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void excluir(@Valid Long lancamento) {
		dao.excluir(lancamento);
	}
	
	public Optional<Lancamento> carregarLancamento(Long lancamento){
		return dao.carregar(lancamento);
	}
}
