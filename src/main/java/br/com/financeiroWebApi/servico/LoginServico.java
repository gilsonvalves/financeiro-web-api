package br.com.financeiroWebApi.servico;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.financeiroWebApi.daos.LoginDao;
import br.com.financeiroWebApi.modal.Login;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class LoginServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginDao loginDao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Login salvarLogin(@Valid Login login) {
		return loginDao.salvar(login);
	}
}
