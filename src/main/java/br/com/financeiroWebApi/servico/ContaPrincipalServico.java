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

import br.com.financeiroWebApi.daos.ContaPrincipalDao;
import br.com.financeiroWebApi.modal.ContaPrincipal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ContaPrincipalServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContaPrincipalDao dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ContaPrincipal salvarConta(@Valid ContaPrincipal entity) {
		return dao.salvar(entity);
	}
	
	public Optional<List<ContaPrincipal>> listaContaPrincipal(){
		return dao.listar();
	}

}
