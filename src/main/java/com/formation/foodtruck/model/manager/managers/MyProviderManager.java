package com.formation.foodtruck.model.manager.managers;

import com.formation.foodtruck.model.entity.MyProvider;

/**
 * The interface ArticleManager. This will handle the DB operations for the
 * articles.
 */
public interface MyProviderManager {

	/**
	 * Method to add a drink to the DB
	 *
	 * @param drink
	 *            the drink that will be added to the DB
	 * @return Boolean.TRUE if added, else Boolean.FALSE if failed
	 */
	public Boolean addProvider(MyProvider provider);

}