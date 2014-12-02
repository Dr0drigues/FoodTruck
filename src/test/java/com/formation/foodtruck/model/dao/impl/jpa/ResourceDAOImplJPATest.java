package com.formation.foodtruck.model.dao.impl.jpa;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.formation.foodtruck.model.dao.ResourceDAO;
import com.formation.foodtruck.model.entity.Command;
import com.formation.foodtruck.model.entity.Gear;
import com.formation.foodtruck.model.entity.Ingredient;
import com.formation.foodtruck.model.entity.Provider;
import com.formation.foodtruck.model.entity.Resource;
import com.formation.foodtruck.model.entity.TypeIngredient;

public class ResourceDAOImplJPATest {
	Provider provider = null;

	@Mock
	private final EntityManager entityManager = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final ResourceDAO resourceDAO = new ResourceDAOImplJPA();

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		provider = new Provider("Fournisseur");
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test create.
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testCreate() throws BadAttributeValueExpException {

		try {
			// Fournisseur OK
			final Resource resourceCreate1 = new Gear("nom", provider);
			final Boolean insert1 = resourceDAO.create(resourceCreate1);
			Assert.assertTrue(insert1);
			final Resource resourceCreate2 = new Ingredient("nom", provider, TypeIngredient.MEAT);
			final Boolean insert2 = resourceDAO.create(resourceCreate2);
			Assert.assertTrue(insert2);

			Mockito.when(entityManager.find(Resource.class, 1)).thenReturn(
					resourceCreate1);

			final Resource commandFound = resourceDAO.find(1);
			Assert.assertNotNull(commandFound);


			// Commande null
			final Resource resourceNull = null;
			final Boolean insert3 = resourceDAO.create(resourceNull);
			Assert.assertFalse(insert3);


		} catch (final SQLException e1) {
			fail("Création impossible");
		}
	}

	/**
	 * Test delete.
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testDelete() throws BadAttributeValueExpException {
		try {
			final Resource resourceCreate1 = new Gear("nom", provider);
			final Resource resourceCreate2 = new Gear("nom", provider);
			final Resource resourceCreate3 = new Ingredient("nom", provider, TypeIngredient.MEAT);
			resourceDAO.create(resourceCreate1);
			resourceDAO.create(resourceCreate2);
			resourceDAO.create(resourceCreate3);

			final Boolean delete1 = resourceDAO.delete(resourceCreate2);
			Assert.assertTrue(delete1);
			final Resource resourceDeleted = resourceDAO.find(2);
			Assert.assertNull(resourceDeleted);

			final Resource resourceNotCreated = null;
			final Boolean delete2 = resourceDAO.delete(resourceNotCreated);
			Assert.assertFalse(delete2);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}

	}

	/**
	 * Test update.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testUpdate() throws SQLException, BadAttributeValueExpException {
		// Fournisseur OK
		final Resource resourceCreate1 = new Gear("nom", provider);
		resourceDAO.create(resourceCreate1);
		final Boolean update1 = resourceDAO.update(resourceCreate1);
		Assert.assertTrue(update1);

		// Resource avec un nom modifier
		final Resource resourceCreateAndSetName = new Ingredient("nom", provider, TypeIngredient.MEAT);
		resourceCreateAndSetName.setName("Resource");
		final Boolean update2 = resourceDAO.update(resourceCreateAndSetName);
		Assert.assertTrue(update2);

		// Commande null
		final Resource resourceNull = null;
		final Boolean update4 = resourceDAO.update(resourceNull);
		Assert.assertFalse(update4);


	}

	/**
	 * Test find.
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testFind() throws BadAttributeValueExpException {
		try {
			final Resource resourceCreate1 = new Gear("nom", provider);
			final Resource resourceCreate2 = new Gear("nom", provider);
			final Resource resourceCreate3 = new Ingredient("nom", provider, TypeIngredient.MEAT);
			resourceDAO.create(resourceCreate1);
			resourceDAO.create(resourceCreate2);
			resourceDAO.create(resourceCreate3);

			Mockito.when(entityManager.find(Resource.class, 2)).thenReturn(
					resourceCreate2);

			final Resource resourceFound = resourceDAO.find(2);
			Assert.assertNotNull(resourceFound);
			Assert.assertEquals(resourceFound, resourceCreate2);

			Mockito.when(entityManager.find(Command.class, 4)).thenReturn(null);

			final Resource ResourceNotFound = resourceDAO.find(4);
			Assert.assertNull(ResourceNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}

	@Test
	public void testFindAllIngredient() throws BadAttributeValueExpException {
		try {
			final Resource resourceCreate1 = new Gear("nom", provider);
			final Resource resourceCreate2 = new Gear("nom", provider);
			final Resource resourceCreate3 = new Ingredient("nom", provider, TypeIngredient.MEAT);
			resourceDAO.create(resourceCreate1);
			resourceDAO.create(resourceCreate2);
			resourceDAO.create(resourceCreate3);

			Mockito.when(entityManager.find(Resource.class, 2)).thenReturn(
					resourceCreate2);

			final Resource resourceFound = resourceDAO.find(2);
			Assert.assertNotNull(resourceFound);
			Assert.assertEquals(resourceFound, resourceCreate2);

			Mockito.when(entityManager.find(Command.class, 4)).thenReturn(null);

			final Resource ResourceNotFound = resourceDAO.find(4);
			Assert.assertNull(ResourceNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}

	@Test
	public void testFindAllGear() throws BadAttributeValueExpException {
		try {
			final Resource resourceCreate1 = new Gear("nom", provider);
			final Resource resourceCreate2 = new Gear("nom", provider);
			final Resource resourceCreate3 = new Ingredient("nom", provider, TypeIngredient.MEAT);
			resourceDAO.create(resourceCreate1);
			resourceDAO.create(resourceCreate2);
			resourceDAO.create(resourceCreate3);

			Mockito.when(entityManager.find(Resource.class, 2)).thenReturn(
					resourceCreate2);

			final Resource resourceFound = resourceDAO.find(2);
			Assert.assertNotNull(resourceFound);
			Assert.assertEquals(resourceFound, resourceCreate2);

			Mockito.when(entityManager.find(Command.class, 4)).thenReturn(null);

			final Resource ResourceNotFound = resourceDAO.find(4);
			Assert.assertNull(ResourceNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}
}
