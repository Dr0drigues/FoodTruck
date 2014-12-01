package com.formation.foodtruck.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private Integer id;
	private String lastName;
	private String firstName;
	private String mail;
	private String password;

	private List<Command> listCommand = new ArrayList<Command>();

	public Client() {
		super();
	}

	public Client(String lastName, String firstName, String mail,
			String password) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.mail = mail;
		this.password = password;
	}

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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the listeCommand
	 */
	public List<Command> getListCommand() {
		return listCommand;
	}

	/**
	 * @param listCommand
	 *            the listCommand to set
	 */
	public void setListCommand(List<Command> listCommand) {
		this.listCommand = listCommand;
	}

}
