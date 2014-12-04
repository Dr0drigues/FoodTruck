/**
 * 
 */
package com.formation.foodtruck.controller;

import java.util.List;

import javax.management.BadAttributeValueExpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.foodtruck.model.entity.Article;
import com.formation.foodtruck.model.entity.Drink;
import com.formation.foodtruck.model.entity.TypeDrink;
import com.formation.foodtruck.model.entity.VolumeDrink;
import com.formation.foodtruck.model.manager.impl.managers.ArticleManagerImpl;

/**
 * @author Administrateur
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleManagerImpl articleManager;

	@RequestMapping(value = "drinks", method = RequestMethod.GET)
	public String printDrinks(ModelMap model) {

		final List<Article> list = articleManager.getDrinkList();
		model.addAttribute("listVolumeDrink", VolumeDrink.values());
		model.addAttribute("listTypeDrink", TypeDrink.values());

		model.addAttribute("listdrink", list);
		model.addAttribute("drink", new Drink());

		Drink drinkTest;
		boolean flag = false;
		try {
			drinkTest = new Drink("Boisson Test", "test", 11,
					VolumeDrink.VOLUME25, TypeDrink.COLDSOFT);

			flag = articleManager.addDrink(drinkTest);
		} catch (BadAttributeValueExpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Test: " + flag);

		return "drinks";
	}

	@RequestMapping(value = "meals", method = RequestMethod.GET)
	public String printMeals(ModelMap model) {

		final List<Article> list = articleManager.getMealList();
		model.addAttribute("listmeal", list);

		return "meals";
	}

	@RequestMapping(value = "adddrink", method = RequestMethod.GET)
	public String showDrink(@ModelAttribute("drink") Drink drink, ModelMap model) {
		return "adddrink";
	}

	@RequestMapping(value = "adddrink", method = RequestMethod.POST)
	public String addDrink(@ModelAttribute("drink") Drink drink, ModelMap model) {
		System.out
				.println("*****************************BITE*******************************\n"
						+ drink.getName()
						+ "****************************BITE*******************************\n");
		if (drink == null || drink.getName() == null
				|| drink.getDescription() == null || drink.getPrice() == null
				|| drink.getName().isEmpty()
				|| drink.getDescription().isEmpty()) {
			return "redirect:drinks";
		}

		System.out
				.println("*****************************BITE*******************************\n"
						+ "AJOUT DE "
						+ drink.getName()
						+ "****************************BITE*******************************\n");
		articleManager.addDrink(drink);
		return "redirect:drinks";
	}
}