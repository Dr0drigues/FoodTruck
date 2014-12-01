package com.formation.foodtruck.model.manager.impl.managers;

import com.formation.foodtruck.model.dao.ClientDAO;
import com.formation.foodtruck.model.entity.Client;
import com.formation.foodtruck.model.manager.managers.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Timmy Parkwayd on 01/12/2014.
 */
public class ClientManagerImpl implements ClientManager {

    @Autowired
    private ClientDAO clientDAO;

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean addClient(Client client) {
        try {
            if (client == null) {
                return Boolean.FALSE;
            }
            clientDAO.create(client);
        } catch (final SQLException e) {
            try {
                clientDAO.delete(client);
            } catch (final SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return Boolean.FALSE;
        }

        return Boolean.TRUE;

    }

    @Override
    public Client getClient(Integer id) throws SQLException {
        return clientDAO.find(id);
    }

    @Override
    @Transactional(readOnly = false)
    public List<Client> getClientList() {
        return clientDAO.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean updateClient(Client client) {
        try {
            clientDAO.update(client);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean removeClient(Client client) {
        try {
            clientDAO.delete(clientDAO.find(client.getId()));
        } catch (final SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
