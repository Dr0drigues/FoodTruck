package com.formation.foodtruck.model.manager.impl.managers;

import com.formation.foodtruck.model.dao.ArticleDAO;
import com.formation.foodtruck.model.entity.Drink;
import com.formation.foodtruck.model.entity.Meal;
import com.formation.foodtruck.model.entity.TypeDrink;
import com.formation.foodtruck.model.entity.VolumeDrink;
import com.formation.foodtruck.model.manager.managers.ArticleManager;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.management.BadAttributeValueExpException;
import java.sql.SQLException;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArticleManagerImplTest {

    @InjectMocks
    private ArticleManager articleManager = Mockito.mock(ArticleManagerImpl.class);

    @Mock
    private ArticleDAO articleDAO = Mockito.mock(ArticleDAO.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMeal() throws BadAttributeValueExpException {

        try {
            Meal articleAdd1 = new Meal("name", ("namae"), 10);
            Meal articleAdd2 = new Meal("name2", ("nombre"), 10);

            when(articleDAO.create(articleAdd1)).thenReturn(true);
            when(articleDAO.create(articleAdd2)).thenReturn(true);

            Boolean insert = articleDAO.create(articleAdd1);
            assertTrue(insert);
            insert = articleDAO.create(articleAdd2);
            assertTrue(insert);

            when(articleDAO.find(1)).thenReturn(articleAdd1);

            Meal articleFound = (Meal) articleDAO.find(1);
            Assert.assertNotNull(articleFound);

            Meal articleNull = null;
            insert = articleDAO.create(articleNull);
            Assert.assertFalse(insert);
        } catch (SQLException e) {
            fail("Cannot create customer");
        }

    }

    @Test
    public void testGetMeal() throws BadAttributeValueExpException {
        try {
            final Meal articleCreate1 = new Meal("name", ("namae"), 10);
            final Meal articleCreate2 = new Meal("name2", ("nombre"), 10);
            final Meal articleCreate3 = new Meal("name3", ("nome"), 10);
            articleDAO.create(articleCreate1);
            articleDAO.create(articleCreate2);
            articleDAO.create(articleCreate3);

            when(articleDAO.find(2)).thenReturn(articleCreate2);

            final Meal articleFound = (Meal) articleDAO.find(2);
            Assert.assertNotNull(articleFound);
            Assert.assertEquals(articleFound, articleCreate2);

            when(articleDAO.find(4)).thenReturn(null);

            final Meal articleNotFound = (Meal) articleDAO.find(4);
            assertNull(articleNotFound);


        } catch (final SQLException e) {
            fail("Récupération impossible");
        }
    }

   /* @Test
    public void testGetMealList() throws Exception {

    }*/

    @Test
    public void testUpdateMeal() throws Exception {
        // Meal OK
        final Meal articleCreate1 = new Meal("name2", ("nombre"), 10);
        articleDAO.create(articleCreate1);
        when(articleDAO.update(articleCreate1)).thenReturn(true);
        final Boolean update1 = articleDAO.update(articleCreate1);
        assertTrue(update1);

        // Meal avec un nom modifier
        final Meal articleCreateAndSetName = new Meal("name2", ("nombre"), 10);
        articleDAO.create(articleCreateAndSetName);
        articleCreateAndSetName.setName("lastName");
        when(articleDAO.update(articleCreateAndSetName)).thenReturn(true);
        final Boolean update2 = articleDAO.update(articleCreateAndSetName);
        assertTrue(update2);


        // Meal null
        final Meal articleNull = null;
        when(articleDAO.update(articleNull)).thenReturn(false);
        final Boolean update4 = articleDAO.update(articleNull);
        assertFalse(update4);
    }

    @Test
    public void testRemoveMeal() throws Exception {
        try {
            final Meal articleCreate1 = new Meal("name1", ("namae"), 10);
            final Meal articleCreate2 = new Meal("name2", ("nombre"), 10);
            final Meal articleCreate3 = new Meal("name3", ("nome"), 10);
            articleDAO.create(articleCreate1);
            articleDAO.create(articleCreate2);
            articleDAO.create(articleCreate3);

            when(articleDAO.delete(articleCreate2)).thenReturn(true);
            final Boolean delete1 = articleDAO.delete(articleCreate2);
            assertTrue(delete1);
            when(articleDAO.find(2)).thenReturn(null);
            final Meal articleDeleted = (Meal) articleDAO.find(2);
            assertNull(articleDeleted);

            final Meal articleNotCreate = null;
            when(articleDAO.delete(articleNotCreate)).thenReturn(false);
            final Boolean delete2 = articleDAO.delete(articleNotCreate);
            assertFalse(delete2);


        } catch (final SQLException e) {
            fail("Suppression impossible");
        }
    }

    @Test
    public void testAddDrink() throws BadAttributeValueExpException {

        try {
            Drink articleAdd1 = new Drink("name", "namae", 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);
            Drink articleAdd2 = new Drink("name2", "nombre", 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);

            when(articleDAO.create(articleAdd1)).thenReturn(true);
            when(articleDAO.create(articleAdd2)).thenReturn(true);

            Boolean insert = articleDAO.create(articleAdd1);
            assertTrue(insert);
            insert = articleDAO.create(articleAdd2);
            assertTrue(insert);

            when(articleDAO.find(1)).thenReturn(articleAdd1);

            Drink articleFound = (Drink) articleDAO.find(1);
            Assert.assertNotNull(articleFound);

            Drink articleNull = null;
            insert = articleDAO.create(articleNull);
            Assert.assertFalse(insert);
        } catch (SQLException e) {
            fail("Cannot create customer");
        }

    }

    @Test
    public void testGetDrink() throws BadAttributeValueExpException {
        try {
            final Drink articleCreate1 = new Drink("name", "namae", 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);
            final Drink articleCreate2 = new Drink("name2", "nombre", 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);
            final Drink articleCreate3 = new Drink("name3", ("nome"), 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);
            articleDAO.create(articleCreate1);
            articleDAO.create(articleCreate2);
            articleDAO.create(articleCreate3);

            when(articleDAO.find(2)).thenReturn(articleCreate2);

            final Drink articleFound = (Drink) articleDAO.find(2);
            Assert.assertNotNull(articleFound);
            Assert.assertEquals(articleFound, articleCreate2);

            when(articleDAO.find(4)).thenReturn(null);

            final Drink articleNotFound = (Drink) articleDAO.find(4);
            assertNull(articleNotFound);


        } catch (final SQLException e) {
            fail("Récupération impossible");
        }
    }

   /* @Test
    public void testGetDrinkList() throws Exception {

    }*/

    @Test
    public void testUpdateDrink() throws Exception {
        // Drink OK
        final Drink articleCreate1 = new Drink("name2", ("nombre"), 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);
        articleDAO.create(articleCreate1);
        when(articleDAO.update(articleCreate1)).thenReturn(true);
        final Boolean update1 = articleDAO.update(articleCreate1);
        assertTrue(update1);

        // Drink avec un nom modifier
        final Drink articleCreateAndSetName = new Drink("name2", ("nombre"), 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);
        articleDAO.create(articleCreateAndSetName);
        articleCreateAndSetName.setName("lastName");
        when(articleDAO.update(articleCreateAndSetName)).thenReturn(true);
        final Boolean update2 = articleDAO.update(articleCreateAndSetName);
        assertTrue(update2);


        // Drink null
        final Drink articleNull = null;
        when(articleDAO.update(articleNull)).thenReturn(false);
        final Boolean update4 = articleDAO.update(articleNull);
        assertFalse(update4);
    }

    @Test
    public void testRemoveDrink() throws Exception {
        try {
            final Drink articleCreate1 = new Drink("name1", ("namae"), 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);
            final Drink articleCreate2 = new Drink("name2", ("nombre"), 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);
            final Drink articleCreate3 = new Drink("name3", ("nome"), 10, VolumeDrink.VOLUME50, TypeDrink.ALCOHOL);
            articleDAO.create(articleCreate1);
            articleDAO.create(articleCreate2);
            articleDAO.create(articleCreate3);

            when(articleDAO.delete(articleCreate2)).thenReturn(true);
            final Boolean delete1 = articleDAO.delete(articleCreate2);
            assertTrue(delete1);
            when(articleDAO.find(2)).thenReturn(null);
            final Drink articleDeleted = (Drink) articleDAO.find(2);
            assertNull(articleDeleted);

            final Drink articleNotCreate = null;
            when(articleDAO.delete(articleNotCreate)).thenReturn(false);
            final Boolean delete2 = articleDAO.delete(articleNotCreate);
            assertFalse(delete2);


        } catch (final SQLException e) {
            fail("Suppression impossible");
        }
    }
}
