package com.formation.foodtruck.model.dao.impl.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.formation.foodtruck.model.dao.CommandLineDAO;
import com.formation.foodtruck.model.entity.CommandLine;

@Repository
public class CommandLineDAOImplJPA implements CommandLineDAO{

	@PersistenceContext
	/**
	 * Appel de l'entityManager pour intégration en base
	 */
	private EntityManager entityManager;

	/**
	 * Méthode de création d'une ligne de commande en base
	 *
	 */

	@Override
	public boolean create(CommandLine cmdLine) throws SQLException {
		if (cmdLine == null){
			return false;
		}
		entityManager.persist(cmdLine);
		return true;
	}

	/**
	 * Méthode de suppression d'une ligne de commande en base
	 *
	 */

	@Override
	public boolean delete(CommandLine cmdLine) throws SQLException {
		if (cmdLine == null){
			return false;
		}
		entityManager.remove(cmdLine);
		return true;
	}

	/**
	 * Méthode de modification d'une ligne de commande en base
	 *
	 */

	@Override
	public boolean update(CommandLine cmdLine) throws SQLException {
		if (cmdLine == null){
			return false;
		}
		entityManager.merge(cmdLine);
		return true;
	}

	/**
	 * Méthode pour trouver une ligne de commande via son ID
	 *
	 */

	@Override
	public CommandLine find(Integer id) throws SQLException {
		if (id == null){
			return null;
		}
		return entityManager.find(CommandLine.class, id);
	}

	/**
	 * méthode pour récupérer toutes les lignes de commande de la base stockés dans une liste
	 * création d'une requête puis affichage via l'entityManager
	 */

	@Override
	public List<CommandLine> findAll() {
		final String request = "select * from articla a";
		final TypedQuery<CommandLine> query = entityManager.createQuery(request, CommandLine.class);
		return query.getResultList();
	}
}
