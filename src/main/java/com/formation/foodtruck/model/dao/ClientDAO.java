package com.formation.foodtruck.model.dao;

import java.util.List;

import com.formation.foodtruck.model.entity.Client;

public interface ClientDAO extends DAO<Client> {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Client> findAll();
}
