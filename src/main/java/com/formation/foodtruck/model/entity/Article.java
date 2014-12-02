package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	private Integer price;

	public Article() {
		super();
	}

	/**
	 * 
	 * @param name
	 * @param description
	 * @param price
	 */

	public Article(String name, String description, Integer price)
			throws BadAttributeValueExpException {
		super();
		if (name == null || name.isEmpty() || description == null
				|| description.isEmpty())
			throw new BadAttributeValueExpException("attribut non renseigné");
		this.name = name;
		this.description = description;
		this.price = price;
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 * @throws BadAttributeValueExpException
	 */
	public void setDescription(String description)
			throws BadAttributeValueExpException {
		if (description == null || description.isEmpty())
			throw new BadAttributeValueExpException("attribut non renseigné");
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
}
