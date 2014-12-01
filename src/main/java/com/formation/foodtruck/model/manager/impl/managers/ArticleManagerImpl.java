package com.formation.foodtruck.model.manager.impl.managers;

import com.formation.foodtruck.model.dao.ArticleDAO;
import com.formation.foodtruck.model.entity.Drink;
import com.formation.foodtruck.model.entity.Meal;
import com.formation.foodtruck.model.manager.managers.ArticleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by Timmy Parkwayd on 01/12/2014.
 */
public class ArticleManagerImpl implements ArticleManager {

    @Autowired
    private ArticleDAO articleDAO;

    @Override
    @Transactional(readOnly = false)
    public Boolean addDrink(Drink drink) {
        if (drink == null) {
            return Boolean.FALSE;
        }
        try {
            articleDAO.create(drink);
        } catch (SQLException e) {
            try {
                articleDAO.delete(drink);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean addMeal(Meal meal) {
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
    public Drink getDrink(Integer id) throws SQLException {
        return (Drink) articleDAO.find(id);
    }

    @Override
    public Meal getMeal(Integer id) throws SQLException {
        return (Meal) articleDAO.find(id);
    }

    /*@Override
    @Transactional(readOnly = false)
    public List<Drink> getDrinkList() {
        return articleDAO.findAllDrink();
    }

    @Override
    @Transactional(readOnly = false)
    public List<Meal> getMealList() {
        return articleDAO.findAllMeal();
    }*/

    @Override
    @Transactional(readOnly = false)
    public Boolean updateDrink(Drink drink) {
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
    public Boolean updateMeal(Meal meal) {
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
    public Boolean removeDrink(Drink drink) {
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
    public Boolean removeMeal(Meal meal) {
        try {
            articleDAO.delete(articleDAO.find(meal.getId()));
        } catch (final SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
