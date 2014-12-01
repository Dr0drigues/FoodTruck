package com.formation.foodtruck.model.dao;

import java.util.List;

import com.formation.foodtruck.model.entity.CommandLine;

public interface CommandLineDAO extends DAO<CommandLine> {


	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<CommandLine> findAll();

}
