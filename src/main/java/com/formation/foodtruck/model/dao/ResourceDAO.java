package com.formation.foodtruck.model.dao;

import java.util.List;

import com.formation.foodtruck.model.entity.Resource;


public interface ResourceDAO extends DAO<Resource>{

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Resource> findAllGear();
	List<Resource> findAllIngredient();
}
