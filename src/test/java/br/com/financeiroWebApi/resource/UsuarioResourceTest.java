package br.com.financeiroWebApi.resource;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.financeiroWebApi.DTO.UsuarioDTO;
import br.com.financeiroWebApi.exception.NegociosException;
import br.com.financeiroWebApi.modal.Usuario;
import br.com.financeiroWebApi.servico.LoginServico;
import br.com.financeiroWebApi.servico.UsuarioServico;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioResourceTest {
	
	UsuarioResource usuarioResource = new UsuarioResource();
	
	@Mock
	private UsuarioServico servico;
	
	@Mock
	private LoginServico LoginDao;
	

	@Test
	public void incluirUsuario() {
		UsuarioDTO user = new UsuarioDTO();
		Response returnTest = usuarioResource.salvarUsuario(user);
		assertEquals(200, returnTest.getStatus());
	}
	
//	@Test
//	public void findUsuario() throws NegociosException {
//		Long codigo = 1l;
//		Optional<Usuario> user = servico.localizar(2l);
//		Response returnTest = usuarioResource.findUsuario(user.get().getCodigo());
//		assertEquals(200, returnTest.getStatus());
//	}
	
	@Before
	public void configTest() {
	}
}
