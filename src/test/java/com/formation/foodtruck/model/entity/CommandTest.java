package com.formation.foodtruck.model.entity;

import java.util.Date;

import javax.management.BadAttributeValueExpException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandTest {

	@InjectMocks
	private final Client client = Mockito.mock(Client.class);

	private Command commandOk = null;
	private Date date = null;

	@Before
	public void setUp() throws Exception {
		date = new Date();
		commandOk = new Command(client, date);
	}

	@Test
	public void testCommandOk() {
		try {
			Assert.assertNotNull(commandOk);
		} catch (Exception e) {
		}
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testCommandClientNull() throws BadAttributeValueExpException {
		final Command commandClientNull = new Command(null, date);
		Assert.assertNull(commandClientNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testCommandDateNull() throws BadAttributeValueExpException {
		final Command commandDateNull = new Command(client, null);
		Assert.assertNull(commandDateNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetClientNull() throws BadAttributeValueExpException {
		Command commandNotOk = commandOk;
		commandNotOk.setClient(null);
		Assert.assertNull(commandNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetIdNull() throws BadAttributeValueExpException {
		Command commandNotOk = commandOk;
		commandNotOk.setId(null);
		Assert.assertNull(commandNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetDateNull() throws BadAttributeValueExpException {
		Command commandNotOk = commandOk;
		commandNotOk.setWithdrawal(null);
		Assert.assertNull(commandNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetListCommandNull() throws BadAttributeValueExpException {
		Command commandNotOk = commandOk;
		commandNotOk.setListCommandLine(null);
		Assert.assertNull(commandNotOk);
	}

	@Test
	public void testSetOk() throws BadAttributeValueExpException {
		Command commandValide = commandOk;
		commandValide.setId(1);
		commandValide.setClient(client);
		commandValide.setWithdrawal(date);
	}
}
