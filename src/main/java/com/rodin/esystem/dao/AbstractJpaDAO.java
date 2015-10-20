package com.rodin.esystem.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;

import com.rodin.esystem.domain.AbstractEntity;

@SuppressWarnings(value = "all")
public abstract class AbstractJpaDAO<Key extends Serializable, T extends AbstractEntity> {
	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> clazz;		

	/*
	 * Constructor that accepts the domain class being managed by DAO
	 */
	protected AbstractJpaDAO(Class<T> clazz) {		
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query query = entityManager.createQuery("from " + clazz.getName());
		return query.getResultList();
	}
	
	public List<T> findAllActive() {
		Query query = entityManager.createQuery("from "+ clazz.getName() +" t where t.status=1");				
		return query.getResultList();
	}

	public T findById(Key id) {
		if (id == null) {
			return null;
		}

		try {
			return getEntityManager().find(clazz, id);
		} catch (EntityNotFoundException e) {
			return null;
		}
	}

	public T save(T entity) {
		this.entityManager.persist(entity);

		return entity;
	}

	public T update(T t) {
		return this.entityManager.merge(t);
	}

	public void delete(Key id) {
		T entity = this.findById(id);

		this.delete(entity);
	}

	public void delete(T entity) {
		if (!(entity == null)) {
			entityManager.remove(entity);
		}
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected Session getSession() {
		return (Session) entityManager.getDelegate();
	}

	protected Class<T> getClazz() {
		return clazz;
	}
}

