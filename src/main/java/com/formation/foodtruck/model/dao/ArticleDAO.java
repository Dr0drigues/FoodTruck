package com.formation.foodtruck.model.dao;

import java.util.List;

import com.formation.foodtruck.model.entity.Article;

public interface ArticleDAO extends DAO<Article> {

	public List<Article> findAllMeal();

	public List<Article> findAllDrink();

}
