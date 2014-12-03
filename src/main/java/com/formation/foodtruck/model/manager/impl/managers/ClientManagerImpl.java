package com.formation.foodtruck.model.manager.impl.managers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.foodtruck.model.dao.ClientDAO;
import com.formation.foodtruck.model.entity.Client;
import com.formation.foodtruck.model.manager.managers.ClientManager;

/**
 * Created by Timmy Parkwayd on 01/12/2014.
 */
@Service
public class ClientManagerImpl implements ClientManager {

	@Autowired
	private ClientDAO clientDAO;

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
		} catch (final SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean removeClient(Client client) {
		if (!client.isDelete()) {
			client.setDelete(true);
			this.updateClient(client);
		}
		return Boolean.TRUE;
	}
}
