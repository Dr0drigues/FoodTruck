/**
 * 
 */
package com.formation.foodtruck.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.BadAttributeValueExpException;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Administrateur
 *
 */
@Entity
public class Command {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date withdrawal;

	@ManyToOne
	private Client client;

	@OneToMany(mappedBy = "command", cascade = CascadeType.PERSIST)
	private List<CommandLine> listCommandLine = new ArrayList<CommandLine>();

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
	 * @return the withdrawal
	 */
	public Date getWithdrawal() {
		return withdrawal;
	}

	/**
	 * @param withdrawal
	 *            the withdrawal to set
	 * @throws BadAttributeValueExpException
	 */
	public void setWithdrawal(Date withdrawal)
			throws BadAttributeValueExpException {
		if (withdrawal == null)
			throw new BadAttributeValueExpException("Id invalide");
		this.withdrawal = withdrawal;
	}

	/**
	 * @return the listCommandLine
	 */
	public List<CommandLine> getListCommandLine() {
		return listCommandLine;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 * @throws BadAttributeValueExpException
	 */
	public void setClient(Client client) throws BadAttributeValueExpException {
		if (client == null)
			throw new BadAttributeValueExpException("Id invalide");
		this.client = client;
	}

	/**
	 * @param listCommandLine
	 *            the listCommandLine to set
	 * @throws BadAttributeValueExpException
	 */
	public void setListCommandLine(List<CommandLine> listCommandLine)
			throws BadAttributeValueExpException {
		if (listCommandLine == null)
			throw new BadAttributeValueExpException("Id invalide");
		this.listCommandLine = listCommandLine;
	}

	/**
	 * 
	 */
	public Command() {
		super();
	}

	public Command(Client client, Date withdrawal)
			throws BadAttributeValueExpException {
		super();
		if (client == null)
			throw new BadAttributeValueExpException("Id invalide");
		if (withdrawal == null)
			throw new BadAttributeValueExpException("Id invalide");
		this.client = client;
		this.withdrawal = withdrawal;
	}

}
