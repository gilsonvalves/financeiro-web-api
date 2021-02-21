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

import br.com.financeiroWebApi.daos.UsuarioDAO;
import br.com.financeiroWebApi.modal.Usuario;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class UsuarioServico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Usuario salvar(@Valid Usuario usuario) {
		return dao.salvar(usuario);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Usuario atualizarUsuario(@Valid Usuario entity) {
		return dao.atualizar(entity);
	}
	
	public Optional<List<Usuario>> getList(){
		return dao.listar();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void excluirUsuario(@Valid Long codigo) {
		dao.excluir(codigo);
	}
	
	public Optional<Usuario> localizar(Long codigo){
		return dao.carregar(codigo);
	}
}
