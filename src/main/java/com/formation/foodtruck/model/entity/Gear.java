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
public class Gear extends Resource {

	/**
	 * 
	 */
	public Gear() {
		super();
	}

	/**
	 * @param name
	 * @throws BadAttributeValueExpException
	 */
	public Gear(String name, MyProvider provider)
			throws BadAttributeValueExpException {
		super(name, provider);
	}

}
