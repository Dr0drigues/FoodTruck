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

import com.formation.foodtruck.model.dao.ProviderDAO;
import com.formation.foodtruck.model.entity.Command;
import com.formation.foodtruck.model.entity.Provider;

public class ProviderDAOImplJPATest {


	@Mock
	private final EntityManager entityManager = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final ProviderDAO providerDAO = new ProviderDAOImplJPA();

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

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
			final Provider providerCreate1 = new Provider("Fournisseur");
			final Boolean insert1 = providerDAO.create(providerCreate1);
			Assert.assertTrue(insert1);
			final Provider providerCreate2 = new Provider("Fournisseur");
			final Boolean insert2 = providerDAO.create(providerCreate2);
			Assert.assertTrue(insert2);

			Mockito.when(entityManager.find(Provider.class, 1)).thenReturn(
					providerCreate1);

			final Provider providerFound = providerDAO.find(1);
			Assert.assertNotNull(providerFound);


			// Commande null
			final Provider providerNull = null;
			final Boolean insert3 = providerDAO.create(providerNull);
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
			final Provider providerCreate1 = new Provider("Fournisseur");
			final Provider providerCreate2 = new Provider("Fournisseur");
			final Provider providerCreate3 = new Provider("Fournisseur");
			providerDAO.create(providerCreate1);
			providerDAO.create(providerCreate2);
			providerDAO.create(providerCreate3);

			final Boolean delete1 = providerDAO.delete(providerCreate2);
			Assert.assertTrue(delete1);
			final Provider providerDeleted = providerDAO.find(2);
			Assert.assertNull(providerDeleted);

			final Provider providerNotCreated = null;
			final Boolean delete2 = providerDAO.delete(providerNotCreated);
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
		final Provider providerCreate1 = new Provider("Fournisseur");
		providerDAO.create(providerCreate1);
		final Boolean update1 = providerDAO.update(providerCreate1);
		Assert.assertTrue(update1);

		// Fournisseur avec un nom modifier
		final Provider providerCreateAndSetName = new Provider("Fournisseur");
		providerCreateAndSetName.setName("Provider");
		final Boolean update2 = providerDAO.update(providerCreateAndSetName);
		Assert.assertTrue(update2);

		// Commande null
		final Provider providerNull = null;
		final Boolean update4 = providerDAO.update(providerNull);
		Assert.assertFalse(update4);


	}

	/**
	 * Test find.
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testFind() throws BadAttributeValueExpException {
		try {
			final Provider providerCreate1 = new Provider("Fournisseur");
			final Provider providerCreate2 = new Provider("Fournisseur");
			final Provider providerCreate3 = new Provider("Fournisseur");
			providerDAO.create(providerCreate1);
			providerDAO.create(providerCreate2);
			providerDAO.create(providerCreate3);

			Mockito.when(entityManager.find(Provider.class, 2)).thenReturn(
					providerCreate2);

			final Provider providerFound = providerDAO.find(2);
			Assert.assertNotNull(providerFound);
			Assert.assertEquals(providerFound, providerCreate2);

			Mockito.when(entityManager.find(Command.class, 4)).thenReturn(null);

			final Provider ProviderNotFound = providerDAO.find(4);
			Assert.assertNull(ProviderNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}
}
