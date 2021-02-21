package br.com.financeiroWebApi.daoGeneric;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;

import br.com.financeiroWebApi.modal.Conta;

public abstract class GenericDao<Objeto, Item extends Serializable> implements GenericDAOInt<Objeto, Item> {
	
	@PersistenceContext(unitName="jpa")
	protected EntityManager entityManager;
	
	private Class<Objeto> classe;
	
	protected GenericDao() {
	}
	
	protected GenericDao(Class<Objeto> classe) {
		this();
		this.classe = classe;
	}
	
	public Objeto salvar(@Valid Objeto entity) {
		entityManager.persist(entity);
		return entity;
	}
	public Objeto atualizar(@Valid Objeto entity) {
		entityManager.merge(entity);
		return entity;
	}
	public void excluir(Item codigo) {
		Objeto entity = carregar(codigo).get();
		getEntityManager().remove(entity);
	}
	public Optional<List<Objeto>> listar(){
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Objeto> query = builder.createQuery(classe);
		query.from(classe);
		return Optional.of(getEntityManager().createQuery(query).getResultList());
	}
	public Optional<Objeto> carregar(Item codigo){
		return Optional.ofNullable(getEntityManager().find(classe, codigo));
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public Conta buscarFavorito(Conta usuario) {	
		return usuario;
	}
	public Item caregarItem(Item codigo) {
		Objeto entity = carregar(codigo).get();
		return codigo;
	}

}
