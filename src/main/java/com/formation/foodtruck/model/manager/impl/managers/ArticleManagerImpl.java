package com.formation.foodtruck.model.manager.impl.managers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.foodtruck.model.dao.ArticleDAO;
import com.formation.foodtruck.model.entity.Article;
import com.formation.foodtruck.model.entity.Drink;
import com.formation.foodtruck.model.entity.Meal;
import com.formation.foodtruck.model.manager.managers.ArticleManager;

/**
 * Created by Timmy Parkwayd on 01/12/2014.
 */
@Service
public class ArticleManagerImpl implements ArticleManager {

	@Autowired
	private ArticleDAO articleDAO;

	@Override
	@Transactional(readOnly = false)
	public Boolean addDrink(Article drink) {
		if (drink == null) {
			return Boolean.FALSE;
		}
		try {
			articleDAO.create(drink);
		} catch (SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean addMeal(Article meal) {
		if (meal == null) {
			return Boolean.FALSE;
		}
		try {
			articleDAO.create(meal);
		} catch (SQLException e) {
			try {
				articleDAO.delete(meal);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	@Transactional(readOnly = true)
	public Drink getDrink(Integer id) throws SQLException {
		return (Drink) articleDAO.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Meal getMeal(Integer id) throws SQLException {
		return (Meal) articleDAO.find(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean updateDrink(Article drink) {
		try {
			articleDAO.update(drink);
		} catch (SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean updateMeal(Article meal) {
		try {
			articleDAO.update(meal);
		} catch (SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean removeDrink(Article drink) {
		try {
			articleDAO.delete(articleDAO.find(drink.getId()));
		} catch (final SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean removeMeal(Article meal) {
		try {
			articleDAO.delete(articleDAO.find(meal.getId()));
		} catch (final SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Article> getDrinkList() {
		try {
			return articleDAO.findAllDrink();
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<Article> getMealList() {
		try {
			return articleDAO.findAllMeal();
		} catch (Exception e) {
			return null;
		}
	}
}
