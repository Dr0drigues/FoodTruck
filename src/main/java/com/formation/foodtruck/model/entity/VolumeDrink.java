/**
 * 
 */
package com.formation.foodtruck.model.entity;

/**
 * @author Administrateur
 *
 */
public enum VolumeDrink {
	VOLUME25(1, "25cl"), VOLUME33(2, "33cl"), VOLUME50(3, "50cl"), VOLUME75(4,
			"75cl"), VOLUME100(5, "100cl");

	private Integer value;
	private String libelle;

	private VolumeDrink(Integer value, String libelle) {
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
