package br.com.financeiroWebApi.daos;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.financeiroWebApi.modal.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDAOTest extends UsuarioDAO {

	@Mock
	UsuarioDAO usuario = new UsuarioDAO();
	
	@Test
	public void salvar() {
		Usuario entity = new Usuario();
		Usuario usuarioSalvo = usuario.salvar(entity);	
		assertEquals(usuarioSalvo, usuarioSalvo);
	}
	
	@Test
	public void carregar() {
		long codigo = 1;
		Optional<Usuario> usuarioSalvo = usuario.carregar(codigo);	
		assertEquals(usuarioSalvo, usuarioSalvo);
	}
	

}
