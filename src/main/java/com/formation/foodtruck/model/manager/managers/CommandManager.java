package com.formation.foodtruck.model.manager.managers;

import com.formation.foodtruck.model.entity.Command;

import java.util.List;

/**
 * The interface CommandManager.
 * This will handle the DB operations for the commands.
 */
public interface CommandManager {
    /**
     * Method to add a command to the DB
     *
     * @param command the command that will be added to the DB
     * @return Boolean.TRUE if added, else Boolean.FALSE if failed
     */
    public Boolean addCommand(Command command);

    /**
     * Method to return a seeked command
     *
     * @param id the id of the searched command
     * @return the seeked command
     * @see Command
     */
    public Command getCommand(Integer id);

    /**
     * Method to return all the commands on the DB
     *
     * @return the List of all commands
     * @see java.util.List
     */
    public List<Command> getCommandList();

    /**
     * Method to update a command information
     *
     * @param command the command to update
     * @return Boolean.TRUE if updated, else Boolean.FALSE if failed
     */
    public Boolean updateCommand(Command command);

    /**
     * Method to delete a command
     *
     * @param command the command to delete
     * @return Boolean.TRUE if deleted, else Boolean.FALSE if failed
     */
    public Boolean removeCommand(Command command);
}
