package com.formation.foodtruck.model.manager.impl.managers;

import com.formation.foodtruck.model.dao.CommandDAO;
import com.formation.foodtruck.model.entity.Client;
import com.formation.foodtruck.model.entity.Command;
import com.formation.foodtruck.model.manager.managers.CommandManager;
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
import java.util.Date;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommandManagerImplTest {

    @InjectMocks
    private CommandManager commandManager = Mockito.mock(CommandManagerImpl.class);

    @Mock
    private CommandDAO commandDAO = Mockito.mock(CommandDAO.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCommand() throws BadAttributeValueExpException {

        try {
            Command commandAdd1 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
            Command commandAdd2 = new Command(new Client("nom2", "prenom2", "ma.i@l.2", "de2rpword"), new Date(2014, 11, 21));

            when(commandDAO.create(commandAdd1)).thenReturn(true);
            when(commandDAO.create(commandAdd2)).thenReturn(true);

            Boolean insert = commandDAO.create(commandAdd1);
            assertTrue(insert);
            insert = commandDAO.create(commandAdd2);
            assertTrue(insert);

            when(commandDAO.find(1)).thenReturn(commandAdd1);

            Command commandFound = commandDAO.find(1);
            Assert.assertNotNull(commandFound);

            Command commandNull = null;
            insert = commandDAO.create(commandNull);
            Assert.assertFalse(insert);
        } catch (SQLException e) {
            fail("Cannot create customer");
        }

    }

    @Test
    public void testGetCommand() throws BadAttributeValueExpException {
        try {
            final Command commandCreate1 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
            final Command commandCreate2 = new Command(new Client("name", "firstname", "mail@mail.derp", "derpass"), new Date(2014, 12, 23));
            final Command commandCreate3 = new Command(new Client("name", "derpName", "mail@mail.derp", "derpass"), new Date(2014, 10, 23));
            commandDAO.create(commandCreate1);
            commandDAO.create(commandCreate2);
            commandDAO.create(commandCreate3);

            when(commandDAO.find(2)).thenReturn(commandCreate2);

            final Command commandFound = commandDAO.find(2);
            Assert.assertNotNull(commandFound);
            Assert.assertEquals(commandFound, commandCreate2);

            when(commandDAO.find(4)).thenReturn(null);

            final Command commandNotFound = commandDAO.find(4);
            assertNull(commandNotFound);


        } catch (final SQLException e) {
            fail("Récupération impossible");
        }
    }

   /* @Test
    public void testGetCommandList() throws Exception {

    }*/

    @Test
    public void testUpdateCommand() throws Exception {
        // Command OK
        final Command commandCreate1 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
        commandDAO.create(commandCreate1);
        when(commandDAO.update(commandCreate1)).thenReturn(true);
        final Boolean update1 = commandDAO.update(commandCreate1);
        assertTrue(update1);

        // Command avec un nom modifier
        final Command commandCreateAndSetDate = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
        commandDAO.create(commandCreateAndSetDate);
        commandCreateAndSetDate.setWithdrawal(new Date(2011, 11, 11));
        when(commandDAO.update(commandCreateAndSetDate)).thenReturn(true);
        final Boolean update2 = commandDAO.update(commandCreateAndSetDate);
        assertTrue(update2);


        // Command null
        final Command commandNull = null;
        when(commandDAO.update(commandNull)).thenReturn(false);
        final Boolean update4 = commandDAO.update(commandNull);
        assertFalse(update4);
    }

    @Test
    public void testRemoveCommand() throws Exception {
        try {
            final Command commandCreate1 = new Command(new Client("name", "firstname", "mail@mail.com", "pass"), new Date(2014, 12, 10));
            final Command commandCreate2 = new Command(new Client("name", "firstname", "mail@mail.derp", "derpass"), new Date(2014, 12, 23));
            final Command commandCreate3 = new Command(new Client("name", "derpName", "mail@mail.derp", "derpass"), new Date(2014, 10, 23));
            commandDAO.create(commandCreate1);
            commandDAO.create(commandCreate2);
            commandDAO.create(commandCreate3);

            when(commandDAO.delete(commandCreate2)).thenReturn(true);
            final Boolean delete1 = commandDAO.delete(commandCreate2);
            assertTrue(delete1);
            when(commandDAO.find(2)).thenReturn(null);
            final Command commandDeleted = commandDAO.find(2);
            assertNull(commandDeleted);

            final Command commandNotCreate = null;
            when(commandDAO.delete(commandNotCreate)).thenReturn(false);
            final Boolean delete2 = commandDAO.delete(commandNotCreate);
            assertFalse(delete2);


        } catch (final SQLException e) {
            fail("Suppression impossible");
        }
    }
}

