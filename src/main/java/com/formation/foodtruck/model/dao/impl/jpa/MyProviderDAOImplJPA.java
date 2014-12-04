package com.formation.foodtruck.model.dao.impl.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.foodtruck.model.dao.MyProviderDAO;
import com.formation.foodtruck.model.entity.MyProvider;

@Repository
public class MyProviderDAOImplJPA implements MyProviderDAO{

	@PersistenceContext
	/**
	 * Appel de l'entityManager pour intégration en base
	 */
	private EntityManager entityManager;


	/**
	 * Méthode de création d'un fournisseur en base
	 *
	 */
	@Override
	public boolean create(MyProvider provider) throws SQLException {
		if (provider == null){
			return false;
		}
		entityManager.persist(provider);
		return true;
	}

	/**
	 * Méthode de suppression d'un fournisseur en base
	 *
	 */

	@Override
	public boolean delete(MyProvider provider) throws SQLException {
		if (provider == null){
			return false;
		}
		entityManager.remove(provider);
		return true;
	}

	/**
	 * Méthode de modification d'un fournisseur en base
	 *
	 */

	@Override
	public boolean update(MyProvider provider) throws SQLException {
		if (provider == null){
			return false;
		}
		entityManager.merge(provider);
		return true;
	}

	/**
	 * Méthode pour trouver un fournisseur via son ID
	 *
	 */

	@Override
	public MyProvider find(Integer id) throws SQLException {
		if (id == null){
			return null;
		}
		return entityManager.find(MyProvider.class, id);
	}

}
