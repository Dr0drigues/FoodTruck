package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class MyProviderTest {

	private MyProvider providerOk = null;

	@Before
	public void setUp() throws Exception {
		providerOk = new MyProvider("nom");
	}

	@Test
	public void testProviderOk() {
		try {
			Assert.assertNotNull(providerOk);
		} catch (Exception e) {
		}
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testProviderNameNull() throws BadAttributeValueExpException {
		final MyProvider providerNameNull = new MyProvider(null);
		Assert.assertNull(providerNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameNull() throws BadAttributeValueExpException {
		MyProvider providerNameNull = providerOk;
		providerNameNull.setName(null);
		Assert.assertNull(providerNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameVide() throws BadAttributeValueExpException {
		MyProvider providerNameNull = providerOk;
		providerNameNull.setName("");
		Assert.assertNull(providerNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetIdNull() throws BadAttributeValueExpException {
		MyProvider providerIdNull = providerOk;
		providerIdNull.setId(null);
		Assert.assertNull(providerIdNull);
	}
}