/**
 * 
 */
package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Administrateur
 *
 */
@Entity
public class CommandLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer quantite;
	@OneToOne
	private Article article;
	@ManyToOne
	private Command command;

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
			throw new BadAttributeValueExpException("Attribut invalide");
		this.id = id;
	}

	/**
	 * @return the quantite
	 */
	public Integer getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite
	 *            the quantite to set
	 * @throws BadAttributeValueExpException
	 */
	public void setQuantite(Integer quantite)
			throws BadAttributeValueExpException {
		if (quantite == null)
			throw new BadAttributeValueExpException("Attribut invalide");
		this.quantite = quantite;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article
	 *            the article to set
	 * @throws BadAttributeValueExpException
	 */
	public void setArticle(Article article)
			throws BadAttributeValueExpException {
		if (article == null)
			throw new BadAttributeValueExpException("Attribut invalide");
		this.article = article;
	}

	/**
	 * @return the command
	 */
	public Command getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 * @throws BadAttributeValueExpException
	 */
	public void setCommand(Command command)
			throws BadAttributeValueExpException {
		if (command == null)
			throw new BadAttributeValueExpException("Attribut invalide");
		this.command = command;
	}

	/**
	 * 
	 */
	public CommandLine() {
		super();
	}

	public CommandLine(Command command, Article article, Integer quantite)
			throws BadAttributeValueExpException {
		super();
		if (command == null || article == null || quantite == null)
			throw new BadAttributeValueExpException("Attribut invalide");
		this.quantite = quantite;
		this.article = article;
		this.command = command;
	}

}
