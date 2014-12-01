/**
 * 
 */
package com.formation.foodtruck.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	 */
	public void setId(Integer id) {
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
	 */
	public void setWithdrawal(Date withdrawal) {
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
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @param listCommandLine
	 *            the listCommandLine to set
	 */
	public void setListCommandLine(List<CommandLine> listCommandLine) {
		this.listCommandLine = listCommandLine;
	}

	/**
	 * 
	 */
	public Command() {
		super();
	}

	public Command(Date withdrawal) {
		super();
		this.withdrawal = withdrawal;
	}

}
