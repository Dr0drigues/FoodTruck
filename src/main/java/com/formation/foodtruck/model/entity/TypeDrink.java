/**
 * 
 */
package com.formation.foodtruck.model.entity;

/**
 * @author Administrateur
 *
 */
public enum TypeDrink {
	COLDSOFT("cold soft"), HOTSOFT("hot soft"), ALCOHOL("alcohol");

	private String libelle;

	private TypeDrink(String libelle) {
		this.libelle = libelle;

	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	@Override
	public String toString() {
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
