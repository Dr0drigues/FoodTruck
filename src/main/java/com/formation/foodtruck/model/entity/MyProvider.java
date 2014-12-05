package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;

	public MyProvider() {
		super();

	}

	public MyProvider(String name) throws BadAttributeValueExpException {
		super();
		if (name == null || name.isEmpty())
			throw new BadAttributeValueExpException("attribut non renseigné");
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 * @throws BadAttributeValueExpException
	 */
	public void setId(Integer id) throws BadAttributeValueExpException {
		if (id == null)
			throw new BadAttributeValueExpException("attribut non renseigné");
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 * @throws BadAttributeValueExpException
	 */
	public void setName(String name) throws BadAttributeValueExpException {
		if (name == null || name.isEmpty())
			throw new BadAttributeValueExpException("attribut non renseigné");
		this.name = name;
	}

}
