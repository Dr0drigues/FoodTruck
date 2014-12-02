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

import com.formation.foodtruck.model.dao.ClientDAO;
import com.formation.foodtruck.model.entity.Client;

public class ClientDAOImplJPATest {


	@Mock
	private final EntityManager entityManager = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final ClientDAO clientDAO = new ClientDAOImplJPA();

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
			// Client OK
			final Client clientCreate1 = new Client("Nom", "Prenom", "mail@mail.com", "pass");
			final Boolean insert1 = clientDAO.create(clientCreate1);
			Assert.assertTrue(insert1);
			final Client clientCreate2 = new Client("Name", "FirstName", "mailounet@mail.com", "pwd");
			final Boolean insert2 = clientDAO.create(clientCreate2);
			Assert.assertTrue(insert2);

			Mockito.when(entityManager.find(Client.class, 1)).thenReturn(
					clientCreate2);

			final Client clientFound = clientDAO.find(1);
			Assert.assertNotNull(clientFound);


			// Client null
			final Client clientNull = null;
			final Boolean insert3 = clientDAO.create(clientNull);
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
			final Client clientCreate1 = new Client("Nom", "Prenom", "mail@mail.com", "pass");
			final Client clientCreate2 = new Client("Name", "FirstName", "mailounet@mail.com", "pwd");
			final Client clientCreate3 = new Client("LastName", "FirstName", "mailounet@mail.com", "pwd");
			clientDAO.create(clientCreate1);
			clientDAO.create(clientCreate2);
			clientDAO.create(clientCreate3);

			final Boolean delete1 = clientDAO.delete(clientCreate2);
			Assert.assertTrue(delete1);
			final Client clientDeleted = clientDAO.find(2);
			Assert.assertNull(clientDeleted);

			final Client clientNotCreate = null;
			final Boolean delete2 = clientDAO.delete(clientNotCreate);
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
		// Client OK
		final Client clientCreate1 = new Client("Nom", "Prenom", "mail@mail.com", "pass");
		clientDAO.create(clientCreate1);
		final Boolean update1 = clientDAO.update(clientCreate1);
		Assert.assertTrue(update1);

		// Client avec un nom modifier
		final Client clientCreateAndSetName = new Client("Nom", "Prenom", "mail@mail.com", "pass");
		clientDAO.create(clientCreateAndSetName);
		clientCreateAndSetName.setLastName("lastName");
		final Boolean update2 = clientDAO.update(clientCreateAndSetName);
		Assert.assertTrue(update2);


		// Client null
		final Client clientNull = null;
		final Boolean update4 = clientDAO.update(clientNull);
		Assert.assertFalse(update4);

	}

	/**
	 * Test find.
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testFind() throws BadAttributeValueExpException {
		try {
			final Client clientCreate1 = new Client("Nom", "Prenom", "mail@mail.com", "pass");
			final Client clientCreate2 = new Client("Name", "FirstName", "mailounet@mail.com", "pwd");
			final Client clientCreate3 = new Client("LastName", "FirstName", "mailounet@mail.com", "pwd");
			clientDAO.create(clientCreate1);
			clientDAO.create(clientCreate2);
			clientDAO.create(clientCreate3);

			Mockito.when(entityManager.find(Client.class, 2)).thenReturn(
					clientCreate2);

			final Client clientFound = clientDAO.find(2);
			Assert.assertNotNull(clientFound);
			Assert.assertEquals(clientFound, clientCreate2);

			Mockito.when(entityManager.find(Client.class, 4)).thenReturn(null);

			final Client clientNotFound = clientDAO.find(4);
			Assert.assertNull(clientNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}

	@Test
	public void testFindAllClient() throws BadAttributeValueExpException {
		try {
			final Client clientCreate1 = new Client("Nom", "Prenom", "mail@mail.com", "pass");
			final Client clientCreate2 = new Client("Name", "FirstName", "mailounet@mail.com", "pwd");
			final Client clientCreate3 = new Client("LastName", "FirstName", "mailounet@mail.com", "pwd");
			clientDAO.create(clientCreate1);
			clientDAO.create(clientCreate2);
			clientDAO.create(clientCreate3);

			Mockito.when(entityManager.find(Client.class, 2)).thenReturn(
					clientCreate2);

			final Client clientFound = clientDAO.find(2);
			Assert.assertNotNull(clientFound);
			Assert.assertEquals(clientFound, clientCreate2);

			Mockito.when(entityManager.find(Client.class, 4)).thenReturn(null);

			final Client clientNotFound = clientDAO.find(4);
			Assert.assertNull(clientNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}


}
