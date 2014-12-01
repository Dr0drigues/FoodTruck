/**
 * 
 */
package com.formation.foodtruck.model.entity;


/**
 * @author Administrateur
 *
 */
public enum TypeDrink {
	COLDSOFT(1, "cold soft"), HOTSOFT(2, "hot soft"), ALCOHOL(3, "alcohol");

	private Integer value;
	private String libelle;

	private TypeDrink(Integer value, String libelle) {
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
