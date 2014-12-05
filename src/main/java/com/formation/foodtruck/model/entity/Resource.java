/**
 * 
 */
package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * @author Administrateur
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@OneToOne
	private MyProvider provider;

	/**
	 * 
	 */
	public Resource() {
		super();
	}

	public Resource(String name, MyProvider provider)
			throws BadAttributeValueExpException {
		super();
		if (name == null || name.isEmpty() || provider == null)
			throw new BadAttributeValueExpException("attribut non renseigné");
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
	 * @return the provider
	 */
	public MyProvider getProvider() {
		return provider;
	}

	/**
	 * @param provider
	 *            the provider to set
	 * @throws BadAttributeValueExpException
	 */
	public void setProvider(MyProvider provider)
			throws BadAttributeValueExpException {
		if (provider == null)
			throw new BadAttributeValueExpException("attribut non renseigné");
		this.provider = provider;
	}

}
