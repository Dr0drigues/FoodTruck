/**
 * 
 */
package com.formation.foodtruck.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrateur
 *
 */
public class Meal extends Article {

	private List<Ingredient> listIngredient = new ArrayList<Ingredient>();

	/**
	 * @return the listIngredient
	 */
	public List<Ingredient> getListIngredient() {
		return listIngredient;
	}

	/**
	 * @param listIngredient
	 *            the listIngredient to set
	 */
	public void setListIngredient(List<Ingredient> listIngredient) {
		this.listIngredient = listIngredient;
	}

	/**
	 * 
	 */
	public Meal() {
		super();
	}

	/**
	 * @param name
	 * @param description
	 * @param price
	 */
	public Meal(String name, String description, Float price) {
		super(name, description, price);
	}

}
