package br.com.financeiroWebApi.daoGeneric;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

public interface GenericDAOInt <Objeto,Item extends Serializable> {
	
	/**
	 * Salvar uma entidade
	 * @param entity
	 * @return
	 */
	
	Objeto salvar(@Valid Objeto entity);
	Objeto atualizar(@Valid Objeto entity);
	void excluir(@Valid Item codigo);
	Optional<Objeto> carregar(Item id);
	//falta buscar Id
	Optional<List<Objeto>> listar();
//	Optional<Usuario> obterPorId(Long id);


}
