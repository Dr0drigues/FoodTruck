package com.formation.foodtruck.model.manager.managers;

import com.formation.foodtruck.model.entity.Provider;

/**
 * The interface ArticleManager. This will handle the DB operations for the
 * articles.
 */
public interface ProviderManager {

	/**
	 * Method to add a drink to the DB
	 *
	 * @param drink
	 *            the drink that will be added to the DB
	 * @return Boolean.TRUE if added, else Boolean.FALSE if failed
	 */
	public Boolean addProvider(Provider provider);

}