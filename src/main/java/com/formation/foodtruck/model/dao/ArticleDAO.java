package com.formation.foodtruck.model.dao;

import java.util.List;

import com.formation.foodtruck.model.entity.Article;

public interface ArticleDAO extends DAO<Article> {
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Article> findAllDrink();

	List<Article> findAllMeal();
}
