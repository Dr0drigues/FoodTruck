package com.formation.foodtruck.model.manager.impl.managers;

import com.formation.foodtruck.model.dao.ResourceDAO;
import com.formation.foodtruck.model.entity.Gear;
import com.formation.foodtruck.model.entity.Ingredient;
import com.formation.foodtruck.model.manager.managers.ResourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by Timmy Parkwayd on 01/12/2014.
 */
public class ResourceManagerImpl implements ResourceManager {

    @Autowired
    private ResourceDAO resourceDAO;

    @Override
    @Transactional(readOnly = false)
    public Boolean addIngredient(Ingredient ingredient) {
        if (ingredient == null) {
            return Boolean.FALSE;
        }
        try {
            resourceDAO.create(ingredient);
        } catch (SQLException e) {
            try {
                resourceDAO.delete(ingredient);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean addGear(Gear gear) {
        if (gear == null) {
            return Boolean.FALSE;
        }
        try {
            resourceDAO.create(gear);
        } catch (SQLException e) {
            try {
                resourceDAO.delete(gear);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Ingredient getIngredient(Integer id) throws SQLException {
        return (Ingredient) resourceDAO.find(id);
    }

    @Override
    public Gear getGear(Integer id) throws SQLException {
        return (Gear) resourceDAO.find(id);
    }

  /*  @Override
    @Transactional(readOnly = false)
    public List<Ingredient> getIngredientList() {
        return resourceDAO.findAllIngredient();
    }

    @Override
    @Transactional(readOnly = false)
    public List<Gear> getGearList() {
        return resourceDAO.findAllGear();
    }*/

    @Override
    @Transactional(readOnly = false)
    public Boolean updateIngredient(Ingredient ingredient) {
        try {
            resourceDAO.update(ingredient);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean updateGear(Gear gear) {
        try {
            resourceDAO.update(gear);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean removeIngredient(Ingredient ingredient) {
        try {
            resourceDAO.delete(resourceDAO.find(ingredient.getId()));
        } catch (final SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean removeGear(Gear gear) {
        try {
            resourceDAO.delete(resourceDAO.find(gear.getId()));
        } catch (final SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
