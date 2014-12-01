package com.formation.foodtruck.model.dao;

import java.util.List;

public interface ResourceDAO extends DAO<Resource>{

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Resource> findAll();
}
