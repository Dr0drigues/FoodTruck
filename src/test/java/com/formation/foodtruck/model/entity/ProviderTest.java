package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ProviderTest {

	private Provider providerOk = null;

	@Before
	public void setUp() throws Exception {
		providerOk = new Provider("nom");
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
		final Provider providerNameNull = new Provider(null);
		Assert.assertNull(providerNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameNull() throws BadAttributeValueExpException {
		Provider providerNameNull = providerOk;
		providerNameNull.setName(null);
		Assert.assertNull(providerNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameVide() throws BadAttributeValueExpException {
		Provider providerNameNull = providerOk;
		providerNameNull.setName("");
		Assert.assertNull(providerNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetIdNull() throws BadAttributeValueExpException {
		Provider providerIdNull = providerOk;
		providerIdNull.setId(null);
		Assert.assertNull(providerIdNull);
	}
}