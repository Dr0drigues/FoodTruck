/**
 * 
 */
package com.formation.foodtruck.model.entity;

/**
 * @author Administrateur
 *
 */
public class Ingredient extends Resource {

	private TypeIngredient type;

	/**
	 * @return the type
	 */
	public TypeIngredient getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeIngredient type) {
		this.type = type;
	}

	/**
	 * 
	 */
	public Ingredient() {
		super();
	}

	/**
	 * @param name
	 * @param provider
	 */
	public Ingredient(String name, Provider provider, TypeIngredient type) {
		super(name, provider);
		this.type = type;
	}

}
