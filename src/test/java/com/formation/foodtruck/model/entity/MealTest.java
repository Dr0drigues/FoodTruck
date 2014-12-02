package com.formation.foodtruck.model.entity;

import javax.management.BadAttributeValueExpException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class MealTest {

	private Article mealOk = null;

	@Before
	public void setUp() throws Exception {
		mealOk = new Meal("nom", "description", 0);

	}

	@Test
	public void testMealOk() {
		try {
			Assert.assertNotNull(mealOk);
		} catch (Exception e) {
		}
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testMealNameNull() throws BadAttributeValueExpException {
		final Article mealNameNull = new Meal(null, "description", 0);
		Assert.assertNull(mealNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testMealDescriptionNull() throws BadAttributeValueExpException {
		final Article mealDescriptionNull = new Meal("nom", null, 0);
		Assert.assertNull(mealDescriptionNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameNull() throws BadAttributeValueExpException {
		Article mealNotOk = mealOk;
		mealNotOk.setName(null);
		Assert.assertNull(mealNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameVide() throws BadAttributeValueExpException {
		Article mealNotOk = mealOk;
		mealNotOk.setName("");
		Assert.assertNull(mealNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetIdNull() throws BadAttributeValueExpException {
		Article mealNotOk = mealOk;
		mealNotOk.setId(null);
		Assert.assertNull(mealNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetDescriptionNull() throws BadAttributeValueExpException {
		Article mealNotOk = mealOk;
		mealNotOk.setDescription(null);
		Assert.assertNull(mealNotOk);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetDescriptionVide() throws BadAttributeValueExpException {
		Article mealNotOk = mealOk;
		mealNotOk.setDescription("");
		Assert.assertNull(mealNotOk);
	}

	@Test
	public void testSetOk() throws BadAttributeValueExpException {
		Article mealValide = mealOk;
		mealValide.setId(1);
		mealValide.setName("nom");
		mealValide.setDescription("description)");
		mealValide.setPrice(1);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testAddIngredient() throws BadAttributeValueExpException {
		Article mealNotOk = mealOk;
		((Meal) mealNotOk).addIngredient(null);
	}
}