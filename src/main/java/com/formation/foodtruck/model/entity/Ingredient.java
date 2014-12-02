/**
 * 
 */
package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;
import javax.persistence.Entity;

/**
 * @author Administrateur
 *
 */
@Entity
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
	 * @throws BadAttributeValueExpException
	 */
	public void setType(TypeIngredient type)
			throws BadAttributeValueExpException {
		if (type == null)
			throw new BadAttributeValueExpException("Type Ingredient invalide");
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
	 * @throws BadAttributeValueExpException
	 */
	public Ingredient(String name, Provider provider, TypeIngredient type)
			throws BadAttributeValueExpException {
		super(name, provider);
		if (type == null)
			throw new BadAttributeValueExpException("attribut invalide");
		this.type = type;
	}

}
