/**
 * 
 */
package com.formation.foodtruck.model.entity;


/**
 * @author Administrateur
 *
 */
public enum TypeIngredient {
	VEGETABLE(1, "vegetable"), MEAT(2, "meat"), SPICE(3, "spice");

	private Integer value;
	private String libelle;

	private TypeIngredient(Integer value, String libelle) {
		this.value = value;
		this.libelle = libelle;

	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
