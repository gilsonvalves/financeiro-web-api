package br.com.financeiroWebApi.daos;

import br.com.financeiroWebApi.daoGeneric.GenericDao;
import br.com.financeiroWebApi.modal.Lancamento;

public class LancamentoDao extends GenericDao<Lancamento, Long> {

	public LancamentoDao() {
		super(Lancamento.class);
	}
}
