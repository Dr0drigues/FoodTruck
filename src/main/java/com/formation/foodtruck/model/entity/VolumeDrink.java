/**
 * 
 */
package com.formation.foodtruck.model.entity;

/**
 * @author Administrateur
 *
 */
public enum VolumeDrink {
	VOLUME25("25cl"), VOLUME33("33cl"), VOLUME50("50cl"), VOLUME75("75cl"), VOLUME100(
			"100cl");

	private String libelle;

	private VolumeDrink(String libelle) {
		this.libelle = libelle;

	}

	@Override
	public String toString() {
		return libelle;
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
