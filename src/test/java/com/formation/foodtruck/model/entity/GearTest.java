package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GearTest {

	@InjectMocks
	private final Provider provider = Mockito.mock(Provider.class);

	private Resource gearOk = null;

	@Before
	public void setUp() throws Exception {
		gearOk = new Gear("nom", provider);
	}

	@Test
	public void testIngredientOk() {
		try {
			Assert.assertNotNull(gearOk);
		} catch (Exception e) {
		}
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testGearNameNull() throws BadAttributeValueExpException {
		final Resource gearNameNull = new Gear(null, provider);
		Assert.assertNull(gearNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testGearProviderNull() throws BadAttributeValueExpException {
		final Resource gearProviderNull = new Gear("nom", null);
		Assert.assertNull(gearProviderNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameNull() throws BadAttributeValueExpException {
		Resource gearNameNull = gearOk;
		gearNameNull.setName(null);
		Assert.assertNull(gearNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameVide() throws BadAttributeValueExpException {
		Resource gearNameNull = gearOk;
		gearNameNull.setName("");
		Assert.assertNull(gearNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetProviderNull() throws BadAttributeValueExpException {
		Resource gearNameNull = gearOk;
		gearNameNull.setProvider(null);
		Assert.assertNull(gearNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetIdNull() throws BadAttributeValueExpException {
		Resource gearNameNull = gearOk;
		gearNameNull.setId(null);
		Assert.assertNull(gearNameNull);
	}
}