package br.com.financeiroWebApi.daos;

import java.util.Optional;

import javax.persistence.TypedQuery;
import br.com.financeiroWebApi.daoGeneric.GenericDao;
import br.com.financeiroWebApi.modal.Conta;
import br.com.financeiroWebApi.modal.Usuario;

public class ContaDao extends GenericDao<Conta, Long> {
	
	public ContaDao() {
		super(Conta.class);
	}

	
	public Optional<Usuario> obterPorId(Long codigo) {
		String jpql =  "select p from Usuario p where p.codigo=:codigo";
		TypedQuery<Usuario> c2 =   entityManager.createQuery(jpql, Usuario.class);
		c2.setParameter("codigo", codigo);
		return c2.getResultStream().findFirst();
	}
	
	public Optional<Conta> obterPorIdConta(Long conta) {
		String jpql =  "select p from Conta p where p.conta=:conta";
		TypedQuery<Conta> c2 =   entityManager.createQuery(jpql, Conta.class);
		c2.setParameter("conta", conta);
		return c2.getResultStream().findFirst();
	}



}
