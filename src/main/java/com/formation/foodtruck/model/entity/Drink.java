/**
 * 
 */
package com.formation.foodtruck.model.entity;

/**
 * @author Administrateur
 *
 */
public class Drink extends Article {

	private VolumeDrink volume;
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
	 */
	public Drink(String name, String description, Float price) {
		super(name, description, price);
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
	 */
	public void setVolume(VolumeDrink volume) {
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
	 */
	public void setType(TypeDrink type, VolumeDrink volume) {
		this.type = type;
		this.volume = volume;
	}

}
