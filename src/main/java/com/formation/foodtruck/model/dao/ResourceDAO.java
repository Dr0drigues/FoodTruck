package com.formation.foodtruck.model.dao;

import com.formation.foodtruck.model.entity.Resource;

import java.util.List;

public interface ResourceDAO extends DAO<Resource>{

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Resource> findAll();
}
