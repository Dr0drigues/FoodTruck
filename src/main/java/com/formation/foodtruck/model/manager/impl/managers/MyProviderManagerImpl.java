package com.formation.foodtruck.model.manager.impl.managers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.foodtruck.model.dao.MyProviderDAO;
import com.formation.foodtruck.model.entity.MyProvider;
import com.formation.foodtruck.model.manager.managers.MyProviderManager;

@Service
public class MyProviderManagerImpl implements MyProviderManager {

	@Autowired
	MyProviderDAO providerDAO;

	@Override
	@Transactional(readOnly = false)
	public Boolean addProvider(MyProvider provider) {
		if (provider == null) {
			return Boolean.FALSE;
		}
		try {
			providerDAO.create(provider);
		} catch (SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
