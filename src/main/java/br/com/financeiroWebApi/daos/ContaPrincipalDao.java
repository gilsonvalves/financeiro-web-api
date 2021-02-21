package br.com.financeiroWebApi.daos;

import java.io.Serializable;

import br.com.financeiroWebApi.daoGeneric.GenericDao;
import br.com.financeiroWebApi.modal.ContaPrincipal;

public class ContaPrincipalDao extends GenericDao<ContaPrincipal, Serializable> {
	
	public ContaPrincipalDao() {
		super(ContaPrincipal.class);
	}
}
