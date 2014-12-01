/**
 * 
 */
package com.formation.foodtruck.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrateur
 *
 */
public class Command {
	private Integer id;
	private Date withdrawal;

	private final List<CommandLine> listCommandLine = new ArrayList<CommandLine>();

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
