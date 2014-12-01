package com.formation.foodtruck.model.dao;

import java.util.List;

public interface CommandLineDAO extends DAO<CommandLine> {


	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<CommandLine> findAll();

}
