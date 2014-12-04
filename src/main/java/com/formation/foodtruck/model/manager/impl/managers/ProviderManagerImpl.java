package com.formation.foodtruck.model.manager.impl.managers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.foodtruck.model.dao.ProviderDAO;
import com.formation.foodtruck.model.entity.Provider;
import com.formation.foodtruck.model.manager.managers.ProviderManager;

@Service
public class ProviderManagerImpl implements ProviderManager {

	@Autowired
	ProviderDAO providerDAO;

	@Override
	@Transactional(readOnly = false)
	public Boolean addProvider(Provider provider) {
		if (provider == null) {
			return Boolean.FALSE;
		}
		try {
			providerDAO.create(provider);
		} catch (SQLException e) {
			try {
				providerDAO.delete(provider);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
