package com.formation.foodtruck.model.dao;

import java.sql.SQLException;

public interface DAO <T>{

	/**
	 * Création
	 * @param obj = création de l'objet
	 * @return
	 * @throws SQLException
	 */


	public abstract boolean create(T obj) throws SQLException;

	/**
	 *Suppression
	 *
	 * @param obj = suppression de l'objet
	 * @return boolean. true si la suppression à eu lieu, false sinon
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract boolean delete(T obj) throws SQLException;

	/**
	 * Mise à jour
	 *
	 * @param obj = update de l'objet
	 * @return boolean
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract boolean update(T obj) throws SQLException;

	/**
	 * Find informations
	 *
	 * @param id = recherche sur l'identifiant
	 * @return T
	 * @throws SQLException
	 *             the SQL exception
	 */
	public abstract T find(Integer id) throws SQLException;

}
