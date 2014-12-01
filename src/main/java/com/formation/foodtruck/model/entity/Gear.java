/**
 * 
 */
package com.formation.foodtruck.model.entity;

import javax.persistence.Entity;

/**
 * @author Administrateur
 *
 */
@Entity
public class Gear extends Resource {

	/**
	 * 
	 */
	public Gear() {
		super();
	}

	/**
	 * @param name
	 */
	public Gear(String name, Provider provider) {
		super(name, provider);
	}

}
