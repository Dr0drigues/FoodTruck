package com.formation.foodtruck.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.management.BadAttributeValueExpException;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String lastName;
	private String firstName;
	private String mail;
	private String password;

	@OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
	private List<Command> listCommand = new ArrayList<Command>();

	public Client() {
		super();
	}

	public Client(String lastName, String firstName, String mail,
			String password) throws BadAttributeValueExpException {
		super();
		if (lastName == null || lastName.isEmpty() || firstName == null
				|| firstName.isEmpty() || mail == null || mail.isEmpty()
				|| password == null || password.isEmpty())
			throw new BadAttributeValueExpException("attribut non renseigné");

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
	public void setId(Integer id) throws BadAttributeValueExpException {
		if (id == null)
			throw new BadAttributeValueExpException("Id invalide");
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
	public void setLastName(String lastName)
			throws BadAttributeValueExpException {
		if (lastName == null || lastName.isEmpty())
			throw new BadAttributeValueExpException("lastName invalide");
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
	public void setFirstName(String firstName)
			throws BadAttributeValueExpException {
		if (firstName == null || firstName.isEmpty())
			throw new BadAttributeValueExpException("firstName invalide");
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
	public void setMail(String mail) throws BadAttributeValueExpException {
		if (mail == null || mail.isEmpty())
			throw new BadAttributeValueExpException("mail invalide");
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
	public void setPassword(String password)
			throws BadAttributeValueExpException {
		if (password == null || password.isEmpty())
			throw new BadAttributeValueExpException("password invalide");
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
