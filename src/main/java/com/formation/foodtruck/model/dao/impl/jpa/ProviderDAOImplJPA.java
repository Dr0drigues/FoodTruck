package com.formation.foodtruck.model.dao.impl.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.formation.foodtruck.model.dao.ProviderDAO;
import com.formation.foodtruck.model.entity.Provider;

public class ProviderDAOImplJPA implements ProviderDAO{


	/**
	 * Appel de l'entityManager pour intégration en base
	 */
	private EntityManager entityManager;


	/**
	 * Méthode de création d'un fournisseur en base
	 *
	 */
	@Override
	public boolean create(Provider provider) throws SQLException {
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
	public boolean delete(Provider provider) throws SQLException {
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
	public boolean update(Provider provider) throws SQLException {
		if (provider == null){
			return false;
		}
		entityManager.persist(provider);
		return true;
	}

	/**
	 * Méthode pour trouver un fournisseur via son ID
	 *
	 */

	@Override
	public Provider find(Integer id) throws SQLException {
		if (id == null){
			return null;
		}
		return entityManager.find(Provider.class, id);
	}

}
