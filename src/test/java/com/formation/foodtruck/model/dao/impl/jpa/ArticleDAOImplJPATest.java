package com.formation.foodtruck.model.dao.impl.jpa;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.formation.foodtruck.model.dao.ArticleDAO;
import com.formation.foodtruck.model.entity.Article;
import com.formation.foodtruck.model.entity.Drink;
import com.formation.foodtruck.model.entity.Meal;
import com.formation.foodtruck.model.entity.TypeDrink;
import com.formation.foodtruck.model.entity.VolumeDrink;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDAOImplJPATest {

	@Mock
	private final EntityManager entityManager = Mockito.mock(EntityManager.class);

	@InjectMocks
	private final ArticleDAO articleDAO = new ArticleDAOImplJPA();


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
			// Article OK
			final Article mealCreate = new Meal("Plat", "description", 8);
			final Boolean insert1 = articleDAO.create(mealCreate);
			Assert.assertTrue(insert1);
			final Article drinkCreate = new Drink("Boisson", "description", 2, VolumeDrink.VOLUME25, TypeDrink.COLDSOFT);
			final Boolean insert2 = articleDAO.create(drinkCreate);
			Assert.assertTrue(insert2);

			Mockito.when(entityManager.find(Article.class, 1)).thenReturn(
					mealCreate);

			final Article articleFound = articleDAO.find(1);
			Assert.assertNotNull(articleFound);




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
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testDelete() throws BadAttributeValueExpException {
		try {
			final Article mealCreate1 = new Meal("Plat1", "description", 8);
			final Article mealCreate2 = new Meal("Plat2", "description", 8);
			final Article drinkCreate3 = new Drink("Boisson", "description", 2, VolumeDrink.VOLUME25, TypeDrink.COLDSOFT);
			articleDAO.create(mealCreate1);
			articleDAO.create(mealCreate2);
			articleDAO.create(drinkCreate3);

			final Boolean delete1 = articleDAO.delete(mealCreate2);
			Assert.assertTrue(delete1);
			final Article articleDeleted = articleDAO.find(2);
			Assert.assertNull(articleDeleted);

			final Article articleNotCreate = null;
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
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testUpdate() throws SQLException, BadAttributeValueExpException {
		// Article OK
		final Article mealCreate1 = new Meal("Plat1", "description", 8);
		articleDAO.create(mealCreate1);
		final Boolean update1 = articleDAO.update(mealCreate1);
		Assert.assertTrue(update1);

		// Article avec un nom modifier
		final Article mealCreateAndSetName = new Meal("Plat2", "description", 8);
		articleDAO.create(mealCreateAndSetName);
		mealCreateAndSetName.setName("Meal 2");
		final Boolean update2 = articleDAO.update(mealCreateAndSetName);
		Assert.assertTrue(update2);


		// Article null
		final Article articleNull = null;
		final Boolean update4 = articleDAO.update(articleNull);
		Assert.assertFalse(update4);


	}

	/**
	 * Test find.
	 * @throws BadAttributeValueExpException
	 */
	@Test
	public void testFind() throws BadAttributeValueExpException {
		try {
			final Article mealCreate1 = new Meal("Plat1", "description", 8);
			final Article mealCreate2 = new Meal("Plat2", "description", 8);
			final Article drinkCreate3 = new Drink("Boisson", "description", 2, VolumeDrink.VOLUME25, TypeDrink.COLDSOFT);
			articleDAO.create(mealCreate1);
			articleDAO.create(mealCreate2);
			articleDAO.create(drinkCreate3);

			Mockito.when(entityManager.find(Article.class, 2)).thenReturn(
					mealCreate2);

			final Article articleFound = articleDAO.find(2);
			Assert.assertNotNull(articleFound);
			Assert.assertEquals(articleFound, mealCreate2);

			Mockito.when(entityManager.find(Article.class, 4)).thenReturn(null);

			final Article articleNotFound = articleDAO.find(4);
			Assert.assertNull(articleNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}

	@Test
	public void testFindAllMeal() throws BadAttributeValueExpException {
		try {
			final Article mealCreate1 = new Meal("Plat1", "description", 8);
			final Article mealCreate2 = new Meal("Plat2", "description", 8);
			final Article mealCreate3 = new Meal("Plat3", "description", 8);
			articleDAO.create(mealCreate1);
			articleDAO.create(mealCreate2);
			articleDAO.create(mealCreate3);

			Mockito.when(entityManager.find(Article.class, 2)).thenReturn(
					mealCreate2);

			final Article articleFound = articleDAO.find(2);
			Assert.assertNotNull(articleFound);
			Assert.assertEquals(articleFound, mealCreate2);

			Mockito.when(entityManager.find(Article.class, 4)).thenReturn(null);

			final Article articleNotFound = articleDAO.find(4);
			Assert.assertNull(articleNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}

	@Test
	public void testFindAllDrink() throws BadAttributeValueExpException {
		try {
			final Article mealCreate1 = new Drink("Boisson1", "description", 2, VolumeDrink.VOLUME33, TypeDrink.COLDSOFT);
			final Article mealCreate2 = new Drink("Boisson2", "description", 1, VolumeDrink.VOLUME25, TypeDrink.COLDSOFT);
			final Article mealCreate3 = new Drink("Boisson3", "description", 5, VolumeDrink.VOLUME50, TypeDrink.COLDSOFT);
			articleDAO.create(mealCreate1);
			articleDAO.create(mealCreate2);
			articleDAO.create(mealCreate3);

			Mockito.when(entityManager.find(Article.class, 2)).thenReturn(
					mealCreate2);

			final Article articleFound = articleDAO.find(2);
			Assert.assertNotNull(articleFound);
			Assert.assertEquals(articleFound, mealCreate2);

			Mockito.when(entityManager.find(Article.class, 4)).thenReturn(null);

			final Article articleNotFound = articleDAO.find(4);
			Assert.assertNull(articleNotFound);


		} catch (final SQLException e) {
			fail("Suppression impossible");
		}
	}


}
