package com.formation.foodtruck.model.manager.managers;

import com.formation.foodtruck.model.entity.Drink;
import com.formation.foodtruck.model.entity.Meal;

import java.sql.SQLException;

/**
 * The interface ArticleManager.
 * This will handle the DB operations for the articles.
 */
public interface ArticleManager {

    /**
     * Method to add a drink to the DB
     *
     * @param drink the drink that will be added to the DB
     * @return Boolean.TRUE if added, else Boolean.FALSE if failed
     */
    public Boolean addDrink(Drink drink);

    /**
     * Method to add a meal to the DB
     *
     * @param meal the meal that will be added to the DB
     * @return Boolean.TRUE if added, else Boolean.FALSE if failed
     */
    public Boolean addMeal(Meal meal);

    /**
     * Method to return a seeked drink
     *
     * @param id the id of the searched drink
     * @return the seeked drink
     * @see Drink
     */
    public Drink getDrink(Integer id) throws SQLException;

    /**
     * Method to return a seeked meal
     *
     * @param id the id of the searched meal
     * @return the seeked meal
     * @see Meal
     */
    public Meal getMeal(Integer id) throws SQLException;

    /**
     * Method to return all the drinks on the DB
     *
     * @return the List of all drinks
     * @see java.util.List
     */
    // public List<Drink> getDrinkList();

    /**
     * Method to return all the meals on the DB
     *
     * @return the List of all meals
     * @see java.util.List
     */
    //public List<Meal> getMealList();

    /**
     * Method to update a drink information
     *
     * @param drink the drink to update
     * @return Boolean.TRUE if updated, else Boolean.FALSE if failed
     */
    public Boolean updateDrink(Drink drink);

    /**
     * Method to update a meal information
     *
     * @param meal the meal to update
     * @return Boolean.TRUE if updated, else Boolean.FALSE if failed
     */
    public Boolean updateMeal(Meal meal);

    /**
     * Method to delete a drink
     *
     * @param drink the drink to delete
     * @return Boolean.TRUE if deleted, else Boolean.FALSE if failed
     */
    public Boolean removeDrink(Drink drink);

    /**
     * Method to delete a meal
     *
     * @param meal the meal to delete
     * @return Boolean.TRUE if deleted, else Boolean.FALSE if failed
     */
    public Boolean removeMeal(Meal meal);

}
