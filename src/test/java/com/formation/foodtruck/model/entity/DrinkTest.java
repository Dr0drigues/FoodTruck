package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DrinkTest {

	Article drinkOk = null;

	@Before
	public void setUp() throws Exception {
		drinkOk = new Meal("nom", "description", 0);

	}

	@Test
	public void testDrinkOk() {
		try {
			Assert.assertNotNull(drinkOk);
		} catch (Exception e) {
		}
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testDrinkNameNull() throws BadAttributeValueExpException {
		final Article drinkNameNull = new Drink(null, "description", 0,
				VolumeDrink.VOLUME25, TypeDrink.COLDSOFT);
		Assert.assertNull(drinkNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testDrinkDescriptionNull() throws BadAttributeValueExpException {
		final Article drinkDescriptionNull = new Drink("nom", null, 0,
				VolumeDrink.VOLUME25, TypeDrink.COLDSOFT);
		Assert.assertNull(drinkDescriptionNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameNull() throws BadAttributeValueExpException {
		Article drinkNotOk = drinkOk;
		drinkNotOk.setName(null);
		Assert.assertNull(drinkNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameVide() throws BadAttributeValueExpException {
		Article drinkNotOk = drinkOk;
		drinkNotOk.setName("");
		Assert.assertNull(drinkNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetIdNull() throws BadAttributeValueExpException {
		Article drinkNotOk = drinkOk;
		drinkNotOk.setId(null);
		Assert.assertNull(drinkNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetDescriptionNull() throws BadAttributeValueExpException {
		Article drinkNotOk = drinkOk;
		drinkNotOk.setDescription(null);
		Assert.assertNull(drinkNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetDescriptionVide() throws BadAttributeValueExpException {
		Article drinkNotOk = drinkOk;
		drinkNotOk.setDescription("");
		Assert.assertNull(drinkNotOk);
	}

	@Test
	public void testSetOk() throws BadAttributeValueExpException {
		Article drinkValide = drinkOk;
		drinkValide.setId(1);
		drinkValide.setName("nom");
		drinkValide.setDescription("description)");
		drinkValide.setPrice(1);
		drinkValide.setPrice(1);
	}
}