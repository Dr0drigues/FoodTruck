/**
 * 
 */
package com.formation.foodtruck.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.management.BadAttributeValueExpException;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Administrateur
 *
 */
@Entity
public class Meal extends Article {

	@OneToMany(cascade = CascadeType.PERSIST)
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
	 * @throws BadAttributeValueExpException
	 */
	public Meal(String name, String description, Integer price)
			throws BadAttributeValueExpException {
		super(name, description, price);
	}

	/**
	 * 
	 * @param ingredient
	 * @throws BadAttributeValueExpException
	 */
	public void addIngredient(Ingredient ingredient)
			throws BadAttributeValueExpException {
		if (ingredient == null)
			throw new BadAttributeValueExpException("attribut non renseigné");
		listIngredient.add(ingredient);
	}

}
