package com.formation.foodtruck.model.manager.impl.managers;

import com.formation.foodtruck.model.dao.ResourceDAO;
import com.formation.foodtruck.model.entity.Gear;
import com.formation.foodtruck.model.entity.Ingredient;
import com.formation.foodtruck.model.entity.MyProvider;
import com.formation.foodtruck.model.entity.TypeIngredient;
import com.formation.foodtruck.model.manager.managers.ResourceManager;
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
public class ResourceManagerImplTest {

    @InjectMocks
    private ResourceManager resourceManager = Mockito.mock(ResourceManagerImpl.class);

    @Mock
    private ResourceDAO resourceDAO = Mockito.mock(ResourceDAO.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddGear() throws BadAttributeValueExpException {

        try {
            Gear resourceAdd1 = new Gear("name", new MyProvider("namae"));
            Gear resourceAdd2 = new Gear("name2", new MyProvider("nombre"));

            when(resourceDAO.create(resourceAdd1)).thenReturn(true);
            when(resourceDAO.create(resourceAdd2)).thenReturn(true);

            Boolean insert = resourceDAO.create(resourceAdd1);
            assertTrue(insert);
            insert = resourceDAO.create(resourceAdd2);
            assertTrue(insert);

            when(resourceDAO.find(1)).thenReturn(resourceAdd1);

            Gear resourceFound = (Gear) resourceDAO.find(1);
            Assert.assertNotNull(resourceFound);

            Gear resourceNull = null;
            insert = resourceDAO.create(resourceNull);
            Assert.assertFalse(insert);
        } catch (SQLException e) {
            fail("Cannot create customer");
        }

    }

    @Test
    public void testGetGear() throws BadAttributeValueExpException {
        try {
            final Gear resourceCreate1 = new Gear("name", new MyProvider("namae"));
            final Gear resourceCreate2 = new Gear("name2", new MyProvider("nombre"));
            final Gear resourceCreate3 = new Gear("name3", new MyProvider("nome"));
            resourceDAO.create(resourceCreate1);
            resourceDAO.create(resourceCreate2);
            resourceDAO.create(resourceCreate3);

            when(resourceDAO.find(2)).thenReturn(resourceCreate2);

            final Gear resourceFound = (Gear) resourceDAO.find(2);
            Assert.assertNotNull(resourceFound);
            Assert.assertEquals(resourceFound, resourceCreate2);

            when(resourceDAO.find(4)).thenReturn(null);

            final Gear resourceNotFound = (Gear) resourceDAO.find(4);
            assertNull(resourceNotFound);


        } catch (final SQLException e) {
            fail("Récupération impossible");
        }
    }

   /* @Test
    public void testGetGearList() throws Exception {

    }*/

    @Test
    public void testUpdateGear() throws Exception {
        // Gear OK
        final Gear resourceCreate1 = new Gear("name2", new MyProvider("nombre"));
        resourceDAO.create(resourceCreate1);
        when(resourceDAO.update(resourceCreate1)).thenReturn(true);
        final Boolean update1 = resourceDAO.update(resourceCreate1);
        assertTrue(update1);

        // Gear avec un nom modifier
        final Gear resourceCreateAndSetName = new Gear("name2", new MyProvider("nombre"));
        resourceDAO.create(resourceCreateAndSetName);
        resourceCreateAndSetName.setName("lastName");
        when(resourceDAO.update(resourceCreateAndSetName)).thenReturn(true);
        final Boolean update2 = resourceDAO.update(resourceCreateAndSetName);
        assertTrue(update2);


        // Gear null
        final Gear resourceNull = null;
        when(resourceDAO.update(resourceNull)).thenReturn(false);
        final Boolean update4 = resourceDAO.update(resourceNull);
        assertFalse(update4);
    }

    @Test
    public void testRemoveGear() throws Exception {
        try {
            final Gear resourceCreate1 = new Gear("name1", new MyProvider("namae"));
            final Gear resourceCreate2 = new Gear("name2", new MyProvider("nombre"));
            final Gear resourceCreate3 = new Gear("name3", new MyProvider("nome"));
            resourceDAO.create(resourceCreate1);
            resourceDAO.create(resourceCreate2);
            resourceDAO.create(resourceCreate3);

            when(resourceDAO.delete(resourceCreate2)).thenReturn(true);
            final Boolean delete1 = resourceDAO.delete(resourceCreate2);
            assertTrue(delete1);
            when(resourceDAO.find(2)).thenReturn(null);
            final Gear resourceDeleted = (Gear) resourceDAO.find(2);
            assertNull(resourceDeleted);

            final Gear resourceNotCreate = null;
            when(resourceDAO.delete(resourceNotCreate)).thenReturn(false);
            final Boolean delete2 = resourceDAO.delete(resourceNotCreate);
            assertFalse(delete2);


        } catch (final SQLException e) {
            fail("Suppression impossible");
        }
    }

    @Test
    public void testAddIngredient() throws BadAttributeValueExpException {

        try {
            Ingredient resourceAdd1 = new Ingredient("name", new MyProvider("namae"), TypeIngredient.MEAT);
            Ingredient resourceAdd2 = new Ingredient("name2", new MyProvider("nombre"), TypeIngredient.MEAT);

            when(resourceDAO.create(resourceAdd1)).thenReturn(true);
            when(resourceDAO.create(resourceAdd2)).thenReturn(true);

            Boolean insert = resourceDAO.create(resourceAdd1);
            assertTrue(insert);
            insert = resourceDAO.create(resourceAdd2);
            assertTrue(insert);

            when(resourceDAO.find(1)).thenReturn(resourceAdd1);

            Ingredient resourceFound = (Ingredient) resourceDAO.find(1);
            Assert.assertNotNull(resourceFound);

            Ingredient resourceNull = null;
            insert = resourceDAO.create(resourceNull);
            Assert.assertFalse(insert);
        } catch (SQLException e) {
            fail("Cannot create customer");
        }

    }

    @Test
    public void testGetIngredient() throws BadAttributeValueExpException {
        try {
            final Ingredient resourceCreate1 = new Ingredient("name", new MyProvider("namae"), TypeIngredient.MEAT);
            final Ingredient resourceCreate2 = new Ingredient("name2", new MyProvider("nombre"), TypeIngredient.MEAT);
            final Ingredient resourceCreate3 = new Ingredient("name3", new MyProvider("nome"), TypeIngredient.MEAT);
            resourceDAO.create(resourceCreate1);
            resourceDAO.create(resourceCreate2);
            resourceDAO.create(resourceCreate3);

            when(resourceDAO.find(2)).thenReturn(resourceCreate2);

            final Ingredient resourceFound = (Ingredient) resourceDAO.find(2);
            Assert.assertNotNull(resourceFound);
            Assert.assertEquals(resourceFound, resourceCreate2);

            when(resourceDAO.find(4)).thenReturn(null);

            final Ingredient resourceNotFound = (Ingredient) resourceDAO.find(4);
            assertNull(resourceNotFound);


        } catch (final SQLException e) {
            fail("Récupération impossible");
        }
    }

   /* @Test
    public void testGetIngredientList() throws Exception {

    }*/

    @Test
    public void testUpdateIngredient() throws Exception {
        // Ingredient OK
        final Ingredient resourceCreate1 = new Ingredient("name2", new MyProvider("nombre"), TypeIngredient.MEAT);
        resourceDAO.create(resourceCreate1);
        when(resourceDAO.update(resourceCreate1)).thenReturn(true);
        final Boolean update1 = resourceDAO.update(resourceCreate1);
        assertTrue(update1);

        // Ingredient avec un nom modifier
        final Ingredient resourceCreateAndSetName = new Ingredient("name2", new MyProvider("nombre"), TypeIngredient.MEAT);
        resourceDAO.create(resourceCreateAndSetName);
        resourceCreateAndSetName.setName("lastName");
        when(resourceDAO.update(resourceCreateAndSetName)).thenReturn(true);
        final Boolean update2 = resourceDAO.update(resourceCreateAndSetName);
        assertTrue(update2);


        // Ingredient null
        final Ingredient resourceNull = null;
        when(resourceDAO.update(resourceNull)).thenReturn(false);
        final Boolean update4 = resourceDAO.update(resourceNull);
        assertFalse(update4);
    }

    @Test
    public void testRemoveIngredient() throws Exception {
        try {
            final Ingredient resourceCreate1 = new Ingredient("name1", new MyProvider("namae"), TypeIngredient.MEAT);
            final Ingredient resourceCreate2 = new Ingredient("name2", new MyProvider("nombre"), TypeIngredient.MEAT);
            final Ingredient resourceCreate3 = new Ingredient("name3", new MyProvider("nome"), TypeIngredient.MEAT);
            resourceDAO.create(resourceCreate1);
            resourceDAO.create(resourceCreate2);
            resourceDAO.create(resourceCreate3);

            when(resourceDAO.delete(resourceCreate2)).thenReturn(true);
            final Boolean delete1 = resourceDAO.delete(resourceCreate2);
            assertTrue(delete1);
            when(resourceDAO.find(2)).thenReturn(null);
            final Ingredient resourceDeleted = (Ingredient) resourceDAO.find(2);
            assertNull(resourceDeleted);

            final Ingredient resourceNotCreate = null;
            when(resourceDAO.delete(resourceNotCreate)).thenReturn(false);
            final Boolean delete2 = resourceDAO.delete(resourceNotCreate);
            assertFalse(delete2);


        } catch (final SQLException e) {
            fail("Suppression impossible");
        }
    }
}
