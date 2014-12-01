package com.formation.foodtruck.model.entity;

public abstract class Article {

	private Integer id;
	private String name;
	private String description;
	private Float price;

	public Article() {
		super();
	}

	/**
	 * 
	 * @param name
	 * @param description
	 * @param price
	 */

	public Article(String name, String description, Float price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
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
	 */
	public void setName(String name) {
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
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

}
