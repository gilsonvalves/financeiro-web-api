package br.com.financeiroWebApi.servico;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.financeiroWebApi.daos.CategoriaDao;
import br.com.financeiroWebApi.modal.Categoria;
import br.com.financeiroWebApi.modal.Usuario;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CategoriaServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaDao daoCategoria ;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Categoria salvarServico(@Valid Categoria entity) {
		Categoria categoria = new Categoria();
		categoria = entity;
		return daoCategoria.salvar(categoria);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void excluir(@Valid Categoria categoria) {
		daoCategoria.excluir(categoria.getCodigo());
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void listar(Usuario usuario) {
		List<Categoria> lista = daoCategoria.listarCategoria(usuario);
		for(Categoria categoria:lista) {
		daoCategoria.excluir(categoria.getCodigo());
		}
	}

	public Categoria salvarEstruraPadrao(Usuario usuario) {
		Categoria cat = new Categoria(null, 1, usuario, "DESPESA", "Moradia",1);
		CategoriaServico dao = new CategoriaServico();
	return dao.salvarServico(cat);
	}

};

