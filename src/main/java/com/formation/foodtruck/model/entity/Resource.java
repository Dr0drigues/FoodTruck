/**
 * 
 */
package com.formation.foodtruck.model.entity;

/**
 * @author Administrateur
 *
 */
public abstract class Resource {

	private Integer id;
	private String name;
	private Provider provider;

	/**
	 * 
	 */
	public Resource() {
		super();
	}

	public Resource(String name, Provider provider) {
		super();
		this.name = name;
		this.provider = provider;
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
	 */
	public void setId(Integer id) {
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
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the provider
	 */
	public Provider getProvider() {
		return provider;
	}

	/**
	 * @param provider
	 *            the provider to set
	 */
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

}
