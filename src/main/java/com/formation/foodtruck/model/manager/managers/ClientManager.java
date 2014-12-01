package com.formation.foodtruck.model.manager.managers;

import com.formation.foodtruck.model.entity.Client;

import java.sql.SQLException;
import java.util.List;

/**
 * The interface ClientManager.
 * This will handle the DB operations for the clients.
 */
public interface ClientManager {
    /**
     * Method to add a client to the DB
     *
     * @param client the client that will be added to the DB
     * @return Boolean.TRUE if added, else Boolean.FALSE if failed
     */
    public Boolean addClient(Client client);

    /**
     * Method to return a seeked client
     *
     * @param id the id of the searched client
     * @return the seeked client
     * @see Client
     */
    public Client getClient(Integer id) throws SQLException;

    /**
     * Method to return all the clients on the DB
     *
     * @return the List of all clients
     * @see java.util.List
     */
    public List<Client> getClientList();

    /**
     * Method to update a client information
     *
     * @param client the client to update
     * @return Boolean.TRUE if updated, else Boolean.FALSE if failed
     */
    public Boolean updateClient(Client client);

    /**
     * Method to delete a client
     *
     * @param client the client to delete
     * @return Boolean.TRUE if deleted, else Boolean.FALSE if failed
     */
    public Boolean removeClient(Client client);
}
