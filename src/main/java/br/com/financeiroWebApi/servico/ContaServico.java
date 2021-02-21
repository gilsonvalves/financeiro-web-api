package br.com.financeiroWebApi.servico;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.financeiroWebApi.daos.ContaDao;
import br.com.financeiroWebApi.modal.Conta;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ContaServico implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContaDao contaDao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Conta salvarConta(@Valid Conta entity) {
		return contaDao.salvar(entity);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void excluirConta(@Valid Long conta) {
		 contaDao.excluir(conta);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Conta atualizarConta(@Valid Conta entity) {
		return contaDao.atualizar(entity);
	}
	
	public Optional<Conta> carregar(Long conta){
		return contaDao.carregar(conta);
	}
	
	public Optional<List<Conta>> listarConta(){
		return contaDao.listar();
	}
	
	public Conta buscarFavorito(Conta usuario) {
		return contaDao.buscarFavorito(usuario);
	}

}
