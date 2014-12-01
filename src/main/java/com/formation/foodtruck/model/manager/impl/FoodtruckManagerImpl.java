package com.formation.foodtruck.model.manager.impl;

import com.formation.foodtruck.model.manager.FoodtruckManager;
import com.formation.foodtruck.model.manager.managers.ArticleManager;
import com.formation.foodtruck.model.manager.managers.ClientManager;
import com.formation.foodtruck.model.manager.managers.CommandManager;
import com.formation.foodtruck.model.manager.managers.ResourceManager;

/**
 * Created by Timmy Parkwayd on 01/12/2014.
 */
public class FoodtruckManagerImpl implements FoodtruckManager {

    ArticleManager articleManager;

    ClientManager clientManager;

    CommandManager commandManager;

    ResourceManager resourceManager;

}
