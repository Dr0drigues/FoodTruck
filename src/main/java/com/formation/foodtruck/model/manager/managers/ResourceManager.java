package com.formation.foodtruck.model.manager.managers;

import com.formation.foodtruck.model.entity.Gear;
import com.formation.foodtruck.model.entity.Ingredient;

import java.util.List;

/**
 * The interface ResourceManager.
 * This will handle the DB operations for the resources.
 */
public interface ResourceManager {

    /**
     * Method to add a gear to the DB
     *
     * @param gear the gear that will be added to the DB
     * @return Boolean.TRUE if added, else Boolean.FALSE if failed
     */
    public Boolean addGear(Gear gear);

    /**
     * Method to add a ingredient to the DB
     *
     * @param ingredient the ingredient that will be added to the DB
     * @return Boolean.TRUE if added, else Boolean.FALSE if failed
     */
    public Boolean addIngredient(Ingredient ingredient);

    /**
     * Method to return a seeked gear
     *
     * @param id the id of the searched gear
     * @return the seeked gear
     * @see Gear
     */
    public Gear getGear(Integer id);

    /**
     * Method to return a seeked ingredient
     *
     * @param id the id of the searched ingredient
     * @return the seeked ingredient
     * @see Ingredient
     */
    public Ingredient getIngredient(Integer id);

    /**
     * Method to return all the gears on the DB
     *
     * @return the List of all gears
     * @see java.util.List
     */
    public List<Gear> getGearList();

    /**
     * Method to return all the ingredients on the DB
     *
     * @return the List of all ingredients
     * @see java.util.List
     */
    public List<Ingredient> getIngredientList();

    /**
     * Method to update a gear information
     *
     * @param gear the gear to update
     * @return Boolean.TRUE if updated, else Boolean.FALSE if failed
     */
    public Boolean updateGear(Gear gear);

    /**
     * Method to update a ingredient information
     *
     * @param ingredient the ingredient to update
     * @return Boolean.TRUE if updated, else Boolean.FALSE if failed
     */
    public Boolean updateIngredient(Ingredient ingredient);

    /**
     * Method to delete a gear
     *
     * @param gear the gear to delete
     * @return Boolean.TRUE if deleted, else Boolean.FALSE if failed
     */
    public Boolean removeGear(Gear gear);

    /**
     * Method to delete a ingredient
     *
     * @param ingredient the ingredient to delete
     * @return Boolean.TRUE if deleted, else Boolean.FALSE if failed
     */
    public Boolean removeIngredient(Ingredient ingredient);

}
