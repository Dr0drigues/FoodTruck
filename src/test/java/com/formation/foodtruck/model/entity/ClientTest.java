package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {

	Client clientOk = null;

	@Before
	public void setUp() throws Exception {
		clientOk = new Client("nom", "prenom", "mail", "password");

	}

	@Test
	public void testClientOk() {
		try {
			Assert.assertNotNull(clientOk);
		} catch (Exception e) {
		}
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testClientLastNameNull() throws BadAttributeValueExpException {
		final Client clientLastNameNull = new Client(null, "prenom", "mail",
				"password");
		Assert.assertNull(clientLastNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testClientFirstNameNull() throws BadAttributeValueExpException {
		final Client clientFirstNameNull = new Client("nom", null, "mail",
				"password");
		Assert.assertNull(clientFirstNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testClientMailNull() throws BadAttributeValueExpException {
		final Client clientMailNull = new Client("nom", "prenom", null,
				"password");
		Assert.assertNull(clientMailNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testClientPasswordNull() throws BadAttributeValueExpException {
		final Client clientPasswordNull = new Client("nom", "prenom", "mail",
				null);
		Assert.assertNull(clientPasswordNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetLastNameNull() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setLastName(null);
		Assert.assertNull(clientNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetLastNameVide() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setLastName("");
		Assert.assertNull(clientNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetIdNull() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setId(null);
		Assert.assertNull(clientNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetFirstNameNull() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setFirstName(null);
		Assert.assertNull(clientNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetFirstNameVide() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setFirstName("");
		Assert.assertNull(clientNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetMailNull() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setMail(null);
		Assert.assertNull(clientNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetMailVide() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setMail("");
		Assert.assertNull(clientNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetPasswordNull() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setPassword(null);
		Assert.assertNull(clientNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetPasswordVide() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setPassword("");
		Assert.assertNull(clientNotOk);
	}

	@Test
	public void testSetOk() throws BadAttributeValueExpException {

		Client clientNotOk = clientOk;
		clientNotOk.setId(1);
		clientNotOk.setLastName("nom");
		clientNotOk.setFirstName("prénom");
		clientNotOk.setMail("mail");
		clientNotOk.setPassword("password");
	}
}