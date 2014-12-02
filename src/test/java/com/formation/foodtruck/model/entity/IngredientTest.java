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
public class IngredientTest {

	@InjectMocks
	private final Provider provider = Mockito.mock(Provider.class);

	private Resource ingredientOk = null;

	@Before
	public void setUp() throws Exception {
		ingredientOk = new Ingredient("nom", provider, TypeIngredient.MEAT);
	}

	@Test
	public void testIngredientOk() {
		try {
			Assert.assertNotNull(ingredientOk);
		} catch (Exception e) {
		}
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testIngredientNameNull() throws BadAttributeValueExpException {
		final Resource ingredientNameNull = new Ingredient(null, provider,
				TypeIngredient.MEAT);
		Assert.assertNull(ingredientNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testIngredientProviderNull()
			throws BadAttributeValueExpException {
		final Resource ingredientProviderNull = new Ingredient("nom", null,
				TypeIngredient.MEAT);
		Assert.assertNull(ingredientProviderNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameNull() throws BadAttributeValueExpException {
		Resource ingredientNameNull = ingredientOk;
		ingredientNameNull.setName(null);
		Assert.assertNull(ingredientNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetNameVide() throws BadAttributeValueExpException {
		Resource ingredientNameNull = ingredientOk;
		ingredientNameNull.setName("");
		Assert.assertNull(ingredientNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetProviderNull() throws BadAttributeValueExpException {
		Resource ingredientNameNull = ingredientOk;
		ingredientNameNull.setProvider(null);
		Assert.assertNull(ingredientNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetIdNull() throws BadAttributeValueExpException {
		Resource ingredientNameNull = ingredientOk;
		ingredientNameNull.setId(null);
		Assert.assertNull(ingredientNameNull);
	}

	@Test(expected = BadAttributeValueExpException.class)
	public void testSetTupeNull() throws BadAttributeValueExpException {
		Resource ingredientNameNull = ingredientOk;
		((Ingredient) ingredientNameNull).setType(null);
		Assert.assertNull(ingredientNameNull);
	}

	public void testSetOk() throws BadAttributeValueExpException {
		Resource ingredientValide = ingredientOk;
		ingredientValide.setId(1);
		ingredientValide.setName("nom");
		ingredientValide.setProvider(provider);
	}

}