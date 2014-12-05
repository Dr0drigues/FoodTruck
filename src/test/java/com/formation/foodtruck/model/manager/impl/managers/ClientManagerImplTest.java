package com.formation.foodtruck.model.manager.impl.managers;

import com.formation.foodtruck.model.dao.ClientDAO;
import com.formation.foodtruck.model.entity.Client;
import com.formation.foodtruck.model.manager.managers.ClientManager;
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
public class ClientManagerImplTest {

    @InjectMocks
    private ClientManager clientManager = Mockito.mock(ClientManagerImpl.class);

    @Mock
    private ClientDAO clientDAO = Mockito.mock(ClientDAO.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddClient() throws BadAttributeValueExpException {

        try {
            Client clientAdd1 = new Client("nom1", "prenom1", "ma.i@l.1", "derpwo1rd");
            Client clientAdd2 = new Client("nom2", "prenom2", "ma.i@l.2", "de2rpword");

            when(clientDAO.create(clientAdd1)).thenReturn(true);
            when(clientDAO.create(clientAdd2)).thenReturn(true);

            Boolean insert = clientDAO.create(clientAdd1);
            assertTrue(insert);
            insert = clientDAO.create(clientAdd2);
            assertTrue(insert);

            when(clientDAO.find(1)).thenReturn(clientAdd1);

            Client clientFound = clientDAO.find(1);
            Assert.assertNotNull(clientFound);

            Client clientNull = null;
            insert = clientDAO.create(clientNull);
            Assert.assertFalse(insert);
        } catch (SQLException e) {
            fail("Cannot create customer");
        }

    }

    @Test
    public void testGetClient() throws BadAttributeValueExpException {
        try {
            final Client clientCreate1 = new Client("Nom", "Prenom", "mail@mail.com", "pass");
            final Client clientCreate2 = new Client("Name", "FirstName", "mailounet@mail.com", "pwd");
            final Client clientCreate3 = new Client("LastName", "FirstName", "mailounet@mail.com", "pwd");
            clientDAO.create(clientCreate1);
            clientDAO.create(clientCreate2);
            clientDAO.create(clientCreate3);

            when(clientDAO.find(2)).thenReturn(clientCreate2);

            final Client clientFound = clientDAO.find(2);
            Assert.assertNotNull(clientFound);
            Assert.assertEquals(clientFound, clientCreate2);

            when(clientDAO.find(4)).thenReturn(null);

            final Client clientNotFound = clientDAO.find(4);
            assertNull(clientNotFound);


        } catch (final SQLException e) {
            fail("Récupération impossible");
        }
    }

   /* @Test
    public void testGetClientList() throws Exception {

    }*/

    @Test
    public void testUpdateClient() throws Exception {
        // Client OK
        final Client clientCreate1 = new Client("Nom", "Prenom", "mail@mail.com", "pass");
        clientDAO.create(clientCreate1);
        when(clientDAO.update(clientCreate1)).thenReturn(true);
        final Boolean update1 = clientDAO.update(clientCreate1);
        assertTrue(update1);

        // Client avec un nom modifier
        final Client clientCreateAndSetName = new Client("Nom", "Prenom", "mail@mail.com", "pass");
        clientDAO.create(clientCreateAndSetName);
        clientCreateAndSetName.setLastName("lastName");
        when(clientDAO.update(clientCreateAndSetName)).thenReturn(true);
        final Boolean update2 = clientDAO.update(clientCreateAndSetName);
        assertTrue(update2);


        // Client null
        final Client clientNull = null;
        when(clientDAO.update(clientNull)).thenReturn(false);
        final Boolean update4 = clientDAO.update(clientNull);
        assertFalse(update4);
    }

    @Test
    public void testRemoveClient() throws Exception {
        try {
            final Client clientCreate1 = new Client("Nom", "Prenom", "mail@mail.com", "pass");
            final Client clientCreate2 = new Client("Name", "FirstName", "mailounet@mail.com", "pwd");
            final Client clientCreate3 = new Client("LastName", "FirstName", "mailounet@mail.com", "pwd");
            clientDAO.create(clientCreate1);
            clientDAO.create(clientCreate2);
            clientDAO.create(clientCreate3);

            when(clientDAO.delete(clientCreate2)).thenReturn(true);
            final Boolean delete1 = clientDAO.delete(clientCreate2);
            assertTrue(delete1);
            when(clientDAO.find(2)).thenReturn(null);
            final Client clientDeleted = clientDAO.find(2);
            assertNull(clientDeleted);

            final Client clientNotCreate = null;
            when(clientDAO.delete(clientNotCreate)).thenReturn(false);
            final Boolean delete2 = clientDAO.delete(clientNotCreate);
            assertFalse(delete2);


        } catch (final SQLException e) {
            fail("Suppression impossible");
        }
    }
}
