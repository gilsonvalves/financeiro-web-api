package br.com.financeiroWebApi.daos;

import br.com.financeiroWebApi.daoGeneric.GenericDao;
import br.com.financeiroWebApi.modal.Usuario;

public class UsuarioDAO extends GenericDao<Usuario, Long> {
	
	public UsuarioDAO() {
		super(Usuario.class);
	}

}
