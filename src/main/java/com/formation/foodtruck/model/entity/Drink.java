/**
 * 
 */
package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * @author Administrateur
 *
 */
@Entity
public class Drink extends Article {
	@Enumerated
	private VolumeDrink volume;
	@Enumerated
	private TypeDrink type;

	/**
	 * 
	 */
	public Drink() {
		super();
	}

	/**
	 * @param name
	 * @param description
	 * @param price
	 * @throws BadAttributeValueExpException
	 */
	public Drink(String name, String description, Integer price,
			VolumeDrink volume, TypeDrink type)
					throws BadAttributeValueExpException {
		super(name, description, price);
		if (volume == null || type == null)
			throw new BadAttributeValueExpException("Attribut invalide");
		this.volume = volume;
		this.type = type;
	}

	/**
	 * @return the volume
	 */
	public VolumeDrink getVolume() {
		return volume;
	}

	/**
	 * @param volume
	 *            the volume to set
	 * @throws BadAttributeValueExpException
	 */
	public void setVolume(VolumeDrink volume)
			throws BadAttributeValueExpException {
		if (volume == null)
			throw new BadAttributeValueExpException("Attribut invalide");
		this.volume = volume;
	}

	/**
	 * @return the type
	 */
	public TypeDrink getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 * @throws BadAttributeValueExpException
	 */
	public void setType(TypeDrink type) throws BadAttributeValueExpException {
		if (type == null)
			throw new BadAttributeValueExpException("Attribut invalide");
		this.type = type;
	}

}
