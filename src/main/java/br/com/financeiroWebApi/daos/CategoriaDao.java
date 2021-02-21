package br.com.financeiroWebApi.daos;

import java.util.List;

import javax.persistence.Query;

import br.com.financeiroWebApi.daoGeneric.GenericDao;
import br.com.financeiroWebApi.modal.Categoria;
import br.com.financeiroWebApi.modal.Usuario;

public class CategoriaDao extends GenericDao<Categoria, Long> {

	public CategoriaDao() {
		super(Categoria.class);
	}

	public List<Categoria> listarCategoria(Usuario usuario){
		String sql = "select c from Categoria c where c.usuario=:usuario";
		Query query = this.entityManager.createQuery(sql);
		query.setParameter("usuario", usuario.getCodigo());
		List<Categoria> lista = query.getResultList();
		return lista;
	}
}
