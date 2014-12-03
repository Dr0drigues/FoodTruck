package com.formation.foodtruck.model.manager.impl.managers;

import com.formation.foodtruck.model.dao.CommandDAO;
import com.formation.foodtruck.model.entity.Command;
import com.formation.foodtruck.model.manager.managers.CommandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Timmy Parkwayd on 01/12/2014.
 */
public class CommandManagerImpl implements CommandManager {

    @Autowired
    private CommandDAO commandDAO;

    @Override
    @Transactional(readOnly = false)
    public Boolean addCommand(Command command) {
        try {
            if (command == null) {
                return Boolean.FALSE;
            }
            commandDAO.create(command);
        } catch (final SQLException e) {
            try {
                commandDAO.delete(command);
            } catch (final SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return Boolean.FALSE;
        }

        return Boolean.TRUE;

    }

    @Override
    public Command getCommand(Integer id) throws SQLException {
        return commandDAO.find(id);
    }

    @Override
    @Transactional(readOnly = false)
    public List<Command> getCommandList() {
        return commandDAO.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean updateCommand(Command command) {
        try {
            commandDAO.update(command);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean removeCommand(Command command) {
        try {
            commandDAO.delete(commandDAO.find(command.getId()));
        } catch (final SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
