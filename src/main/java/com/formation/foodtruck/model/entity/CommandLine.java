/**
 * 
 */
package com.formation.foodtruck.model.entity;

/**
 * @author Administrateur
 *
 */
public class CommandLine {

	private Integer id;
	private Integer quantite;
	private Article article;

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
	 */
	public void setId(Integer id) {
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
	 */
	public void setQuantite(Integer quantite) {
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
	 */
	public void setArticle(Article article) {
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
	 */
	public void setCommand(Command command) {
		this.command = command;
	}

	/**
	 * 
	 */
	public CommandLine() {
		super();
	}

	public CommandLine(Integer quantite, Article article) {
		super();
		this.quantite = quantite;
		this.article = article;
	}

}
