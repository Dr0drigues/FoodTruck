package com.formation.foodtruck.model.dao.impl.jpa;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Date;

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

import com.formation.foodtruck.model.dao.CommandDAO;
import com.formation.foodtruck.model.entity.Client;
import com.formation.foodtruck.model.entity.Command;

public class CommandDAOImplJPATest {



	@Mock
	private final EntityManager entityManager = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final CommandDAO commandDAO = new CommandDAOImplJPA();

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
			// Commande OK
			final Command commandCreate1 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
			final Boolean insert1 = commandDAO.create(commandCreate1);
			Assert.assertTrue(insert1);
			final Command commandCreate2 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 15));
			final Boolean insert2 = commandDAO.create(commandCreate2);
			Assert.assertTrue(insert2);

			Mockito.when(entityManager.find(Command.class, 1)).thenReturn(
					commandCreate2);

			final Command commandFound = commandDAO.find(1);
			Assert.assertNotNull(commandFound);


			// Commande null
			final Command commandNull = null;
			final Boolean insert3 = commandDAO.create(commandNull);
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
			final Command clientCreate1 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
			final Command clientCreate2 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 15));
			final Command clientCreate3 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 20));
			commandDAO.create(clientCreate1);
			commandDAO.create(clientCreate2);
			commandDAO.create(clientCreate3);

			final Boolean delete1 = commandDAO.delete(clientCreate2);
			Assert.assertTrue(delete1);
			final Command commandDeleted = commandDAO.find(2);
			Assert.assertNull(commandDeleted);

			final Command commandNotCreate = null;
			final Boolean delete2 = commandDAO.delete(commandNotCreate);
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
		// Commande OK
		final Command commandCreate1 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
		commandDAO.create(commandCreate1);
		final Boolean update1 = commandDAO.update(commandCreate1);
		Assert.assertTrue(update1);

		// Commande avec une date modifier
		final Command commandCreateAndSetName = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
		commandDAO.create(commandCreateAndSetName);
		commandCreateAndSetName.setWithdrawal(new Date(2014,10,21));
		final Boolean update2 = commandDAO.update(commandCreateAndSetName);
		Assert.assertTrue(update2);

		// Commande null
		final Command commandNull = null;
		final Boolean update4 = commandDAO.update(commandNull);
		Assert.assertFalse(update4);


	}

	/**
	 * Test find.
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testFind() throws BadAttributeValueExpException {
		try {
			final Command commandCreate1 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
			final Command commandCreate2 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 15));
			final Command commandCreate3 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 20));
			commandDAO.create(commandCreate1);
			commandDAO.create(commandCreate2);
			commandDAO.create(commandCreate3);

			Mockito.when(entityManager.find(Command.class, 2)).thenReturn(
					commandCreate2);

			final Command commandFound = commandDAO.find(2);
			Assert.assertNotNull(commandFound);
			Assert.assertEquals(commandFound, commandCreate2);

			Mockito.when(entityManager.find(Command.class, 4)).thenReturn(null);

			final Command CommandNotFound = commandDAO.find(4);
			Assert.assertNull(CommandNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}

	@Test
	public void testFindAllCommand() throws BadAttributeValueExpException {
		try {
			final Command commandCreate1 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
			final Command commandCreate2 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 15));
			final Command commandCreate3 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 20));
			commandDAO.create(commandCreate1);
			commandDAO.create(commandCreate2);
			commandDAO.create(commandCreate3);

			Mockito.when(entityManager.find(Command.class, 2)).thenReturn(
					commandCreate2);

			final Command commandFound = commandDAO.find(2);
			Assert.assertNotNull(commandFound);
			Assert.assertEquals(commandFound, commandCreate2);

			Mockito.when(entityManager.find(Command.class, 4)).thenReturn(null);

			final Command CommandNotFound = commandDAO.find(4);
			Assert.assertNull(CommandNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}

}
