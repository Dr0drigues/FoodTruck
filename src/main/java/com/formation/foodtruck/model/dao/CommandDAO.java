package com.formation.foodtruck.model.dao;

import com.formation.foodtruck.model.entity.Command;

import java.util.List;

public interface CommandDAO extends DAO<Command>{

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Command> findAll();

}
