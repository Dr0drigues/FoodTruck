package com.formation.foodtruck.model.dao.impl.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.formation.foodtruck.model.dao.ResourceDAO;
import com.formation.foodtruck.model.entity.Resource;

@Repository
public class ResourceDAOImplJPA implements ResourceDAO {


	@PersistenceContext
	/**
	 * Appel de l'entityManager pour intégration en base
	 */
	private EntityManager entityManager;

	/**
	 * Méthode de création d'un article en base
	 *
	 */

	@Override
	public boolean create(Resource resource) throws SQLException {
		if (resource == null){
			return false;
		}
		entityManager.persist(resource);
		return true;
	}

	/**
	 * Méthode de suppression d'un article en base
	 *
	 */

	@Override
	public boolean delete(Resource resource) throws SQLException {
		if (resource == null){
			return false;
		}
		entityManager.remove(resource);
		return true;
	}

	/**
	 * Méthode de modification d'un article en base
	 *
	 */

	@Override
	public boolean update(Resource resource) throws SQLException {
		if (resource == null){
			return false;
		}
		entityManager.merge(resource);
		return true;
	}

	/**
	 * Méthode pour trouver un article via son ID
	 *
	 */

	@Override
	public Resource find(Integer id) throws SQLException {
		if (id == null){
			return null;
		}
		return entityManager.find(Resource.class, id);
	}

	/**
	 * méthode pour récupérer toutes les ressources de la base stockés dans une liste
	 * création d'une requête qui recense tous ingrédients ou matériaux puis affichage via l'entityManager
	 */

	@Override
	public List<Resource> findAllGear() {
		final String request = "select * from resource r where type(r) = Gear";
		final TypedQuery<Resource> query = entityManager.createQuery(request, Resource.class);
		return query.getResultList();
	}

	@Override
	public List<Resource> findAllIngredient() {
		final String request = "select * from resource r where type(r) = Ingredient";
		final TypedQuery<Resource> query = entityManager.createQuery(request, Resource.class);
		return query.getResultList();
	}



}
