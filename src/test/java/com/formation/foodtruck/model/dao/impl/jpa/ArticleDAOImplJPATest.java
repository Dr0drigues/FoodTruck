package com.formation.foodtruck.model.dao.impl.jpa;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.formation.foodtruck.model.dao.ArticleDAO;
import com.formation.foodtruck.model.entity.Article;
import com.formation.foodtruck.model.entity.Drink;
import com.formation.foodtruck.model.entity.Meal;

@RunWith(JUnit4.class)
public class ArticleDAOImplJPATest {

	/** The article dao. */
	private ArticleDAO articleDAO;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {


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
	 */
	@Test
	public void testCreate() {

		try {
			// Article OK
			final Article mealCreate = new Meal("Plat 1", "description", 8.0f);
			final Boolean insert1 = articleDAO.create(mealCreate);
			Assert.assertTrue(insert1);
			final Article drinkCreate = new Drink("Boisson 1", "coca", 1.9f);
			final Boolean insert2 = articleDAO.create(drinkCreate);
			Assert.assertTrue(insert2);
			final Article articleTrouver = articleDAO.find(1);
			Assert.assertNotNull(articleTrouver);

			// Article null
			final Article articleNull = null;
			final Boolean insert3 = articleDAO.create(articleNull);
			Assert.assertFalse(insert3);

		} catch (final SQLException e1) {
			fail("Création impossible");
		}
	}

	/**
	 * Test delete.
	 */
	@Test
	public void testDelete() {
		try {
			final Article mealCreate1 = new Meal("Plat 1","Description", 7.9f);
			final Article mealCreate2 = new Meal("Plat 2","Description", 9.9f);
			final Article drinkCreate3 = new Drink("Boisson 3","Bière", 4.5f);
			articleDAO.create(mealCreate1);
			articleDAO.create(mealCreate2);
			articleDAO.create(drinkCreate3);

			final Boolean delete1 = articleDAO.delete(mealCreate2);
			Assert.assertTrue(delete1);
			final Article articleSupprimer = articleDAO.find(2);
			Assert.assertNull(articleSupprimer);

			final Article articleNotCreate = new Meal("Article 2","Plat non crée", 10.0f);
			final Boolean delete2 = articleDAO.delete(articleNotCreate);
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
	 */
	@Test
	public void testUpdate() throws SQLException {
		// Article OK
		final Article mealCreate1 = new Meal("Plat 1","Description", 7.9f);
		articleDAO.create(mealCreate1);
		final Boolean update1 = articleDAO.update(mealCreate1);
		Assert.assertTrue(update1);

		// Article avec un nom modifier
		final Article mealCreateAndSetNom = new Meal("Plat 1","Description", 6.9f);
		articleDAO.create(mealCreateAndSetNom);
		mealCreateAndSetNom.setName("Meal 1");
		final Boolean update2 = articleDAO.update(mealCreateAndSetNom);
		Assert.assertTrue(update2);

		// Article avec un id modifier à null
		final Article articleCreateAndSetIdNull = new Drink("Boisson gazeuse", "Fanta", 2.2f);
		articleDAO.create(articleCreateAndSetIdNull);
		articleCreateAndSetIdNull.setId(null);
		final Boolean update3 = articleDAO.update(articleCreateAndSetIdNull);
		Assert.assertFalse(update3);

		// Article null
		final Article articleNull = null;
		final Boolean update4 = articleDAO.update(articleNull);
		Assert.assertFalse(update4);

		// Id null
		final Article articleIdNull = new Drink("article null","Produit null", 0.0f);
		final Boolean update5 = articleDAO.delete(articleIdNull);
		Assert.assertFalse(update5);

		// Id no create
		final Article articleNotCreate = new Meal("Meal","plat", 8.5f);
		final Boolean update6 = articleDAO.delete(articleNotCreate);
		Assert.assertFalse(update6);

	}

	/**
	 * Test find.
	 */
	@Test
	public void testFind() {
		try {
			final Article mealCreate1 = new Meal("Plat 1","Description", 7.9f);
			final Article mealCreate2 = new Meal("Plat 2","Description", 9.9f);
			final Article drinkCreate3 = new Drink("Boisson 3","Bière", 4.5f);
			articleDAO.create(mealCreate1);
			articleDAO.create(mealCreate2);
			articleDAO.create(drinkCreate3);

			final Article articleTrouver = articleDAO.find(2);
			Assert.assertNotNull(articleTrouver);
			Assert.assertEquals(articleTrouver, mealCreate2);
			;

			final Article articleNonTrouver = articleDAO.find(4);
			Assert.assertNull(articleNonTrouver);
		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}


}
