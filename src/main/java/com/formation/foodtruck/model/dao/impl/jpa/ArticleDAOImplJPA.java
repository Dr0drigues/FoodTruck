package com.formation.foodtruck.model.dao.impl.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.formation.foodtruck.model.dao.ArticleDAO;
import com.formation.foodtruck.model.entity.Article;

@Repository
public class ArticleDAOImplJPA implements ArticleDAO {

	@PersistenceContext
	/**
	 * Appel de l'entityManager pour intégration en base
	 */
	private EntityManager entityManager;

	/**
	 * Méthode de création d'un article en base
	 *
	 */

	@Override
	public boolean create(Article article) throws SQLException {
		if (article == null) {
			return false;
		}
		entityManager.persist(article);
		return true;
	}

	/**
	 * Méthode de suppression d'un article en base
	 *
	 */

	@Override
	public boolean delete(Article article) throws SQLException {
		if (article == null) {
			return false;
		}
		entityManager.remove(article);
		return true;
	}

	/**
	 * Méthode de modification d'un article en base
	 *
	 */

	@Override
	public boolean update(Article article) throws SQLException {
		if (article == null) {
			return false;
		}
		entityManager.merge(article);
		return true;
	}

	/**
	 * Méthode pour trouver un article via son ID
	 *
	 */

	@Override
	public Article find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		return entityManager.find(Article.class, id);
	}

	/**
	 * méthode pour récupérer tous les articles de la base stockés dans une
	 * liste création d'une requête qui recense tous les plats ou boissons puis
	 * affichage via l'entityManager
	 */

	@Override
	public List<Article> findAllMeal() {
		final String request = "select a from Article a where type(a) = Meal";
		final TypedQuery<Article> query = entityManager.createQuery(request,
				Article.class);
		return query.getResultList();
	}

	@Override
	public List<Article> findAllDrink() {
		final String request = "select a from Article a where type(a) = Drink";
		final TypedQuery<Article> query = entityManager.createQuery(request,
				Article.class);
		return query.getResultList();
	}

}
