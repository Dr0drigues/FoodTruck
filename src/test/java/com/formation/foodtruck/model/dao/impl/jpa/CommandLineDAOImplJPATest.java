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

import com.formation.foodtruck.model.dao.CommandLineDAO;
import com.formation.foodtruck.model.entity.Article;
import com.formation.foodtruck.model.entity.Client;
import com.formation.foodtruck.model.entity.Command;
import com.formation.foodtruck.model.entity.CommandLine;
import com.formation.foodtruck.model.entity.Meal;

public class CommandLineDAOImplJPATest {

	Command command = null;
	Article article = null;

	@Mock
	private final EntityManager entityManager = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final CommandLineDAO commandLineDAO = new CommandLineDAOImplJPA();

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);


		command = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
		article = new Meal("Plat", "Description", 8);
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
			// LigneCommande OK
			final CommandLine commandLineCreate1 = new CommandLine(command, article, 10);
			final Boolean insert1 = commandLineDAO.create(commandLineCreate1);
			Assert.assertTrue(insert1);
			final CommandLine commandLineCreate2 = new CommandLine(command, article, 10);
			final Boolean insert2 = commandLineDAO.create(commandLineCreate2);
			Assert.assertTrue(insert2);

			Mockito.when(entityManager.find(CommandLine.class, 1)).thenReturn(
					commandLineCreate1);

			final CommandLine commandFound = commandLineDAO.find(1);
			Assert.assertNotNull(commandFound);


			// LigneCommande null
			final CommandLine commandNull = null;
			final Boolean insert3 = commandLineDAO.create(commandNull);
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
			final CommandLine clientCreate1 = new CommandLine(command, article, 10);
			final CommandLine clientCreate2 = new CommandLine(command, article, 10);
			final CommandLine clientCreate3 = new CommandLine(command, article, 10);
			commandLineDAO.create(clientCreate1);
			commandLineDAO.create(clientCreate2);
			commandLineDAO.create(clientCreate3);

			final Boolean delete1 = commandLineDAO.delete(clientCreate2);
			Assert.assertTrue(delete1);
			final CommandLine commandDeleted = commandLineDAO.find(2);
			Assert.assertNull(commandDeleted);

			final CommandLine commandNotCreate = null;
			final Boolean delete2 = commandLineDAO.delete(commandNotCreate);
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
		// LigneCommande OK
		final CommandLine commandCreate1 = new CommandLine(command, article, 10);
		commandLineDAO.create(commandCreate1);
		final Boolean update1 = commandLineDAO.update(commandCreate1);
		Assert.assertTrue(update1);

		// LigneCommande avec une qte modifier
		final CommandLine commandCreateAndSetQuantity = new CommandLine(command, article, 10);
		commandCreateAndSetQuantity.setQuantite(20);
		final Boolean update2 = commandLineDAO.update(commandCreateAndSetQuantity);
		Assert.assertTrue(update2);

		// LigneCommande null
		final CommandLine commandNull = null;
		final Boolean update4 = commandLineDAO.update(commandNull);
		Assert.assertFalse(update4);


	}

	/**
	 * Test find.
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testFind() throws BadAttributeValueExpException {
		try {
			final CommandLine commandCreate1 = new CommandLine(command, article, 10);
			final CommandLine commandCreate2 = new CommandLine(command, article, 10);
			final CommandLine commandCreate3 = new CommandLine(command, article, 10);
			commandLineDAO.create(commandCreate1);
			commandLineDAO.create(commandCreate2);
			commandLineDAO.create(commandCreate3);

			Mockito.when(entityManager.find(CommandLine.class, 2)).thenReturn(
					commandCreate2);

			final CommandLine commandFound = commandLineDAO.find(2);
			Assert.assertNotNull(commandFound);
			Assert.assertEquals(commandFound, commandCreate2);

			Mockito.when(entityManager.find(Command.class, 4)).thenReturn(null);

			final CommandLine CommandNotFound = commandLineDAO.find(4);
			Assert.assertNull(CommandNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}

	@Test
	public void testFindAllCommand() throws BadAttributeValueExpException {
		try {
			final CommandLine commandCreate1 = new CommandLine(command, article, 10);
			final CommandLine commandCreate2 = new CommandLine(command, article, 10);
			final CommandLine commandCreate3 = new CommandLine(command, article, 10);
			commandLineDAO.create(commandCreate1);
			commandLineDAO.create(commandCreate2);
			commandLineDAO.create(commandCreate3);

			Mockito.when(entityManager.find(CommandLine.class, 2)).thenReturn(
					commandCreate2);

			final CommandLine commandFound = commandLineDAO.find(2);
			Assert.assertNotNull(commandFound);
			Assert.assertEquals(commandFound, commandCreate2);

			Mockito.when(entityManager.find(Command.class, 4)).thenReturn(null);

			final CommandLine CommandNotFound = commandLineDAO.find(4);
			Assert.assertNull(CommandNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}
}
