package br.com.financeiroWebApi.daos;

import java.util.Optional;

import javax.persistence.TypedQuery;

import br.com.financeiroWebApi.daoGeneric.GenericDao;
import br.com.financeiroWebApi.modal.Login;

public class LoginDao extends GenericDao<Login, Long> {
	
	public LoginDao() {
		super(Login.class);
	}
	
	public Optional<Login> buscarUsuarioPorEmail(String usuarioEmail, String usuarioSenha){
		String jpql =  "select u from Login u where u.usuarioEmail=:usuarioEmail";
		TypedQuery<Login> c2 =   entityManager.createQuery(jpql, Login.class);
		c2.setParameter("usuarioEmail", usuarioEmail);
		//c2.setParameter("senha", senha);
		return c2.getResultStream().findFirst();
	}
	
//	public Optional<Login> buscarUsuarioPorEmail(String email){
//		TypedQuery<Usuario> q2 =
//		 entityManager.createQuery(" select p from Login p where p.email=:email", Login.class);
//		q2.setParameter("email", email);
//		return q2.getResultStream().findFirst();
//	}
}
