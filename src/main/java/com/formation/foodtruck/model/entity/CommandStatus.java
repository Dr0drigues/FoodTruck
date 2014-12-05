/**
 * 
 */
package com.formation.foodtruck.model.entity;

/**
 * @author Administrateur
 *
 */
public enum CommandStatus {
	TENDING("Commande en cours"), CANCELED("Commande annulée"), ARCHIVED(
			"Commande archivée"), READY("Commande prête"), PICKED(
			"Commande retirée par le client");

	private String libelle;

	private CommandStatus(String libelle) {
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
