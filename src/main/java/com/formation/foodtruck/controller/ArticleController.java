/**
 * 
 */
package com.formation.foodtruck.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.foodtruck.model.entity.Article;
import com.formation.foodtruck.model.entity.Drink;
import com.formation.foodtruck.model.entity.TypeDrink;
import com.formation.foodtruck.model.entity.VolumeDrink;
import com.formation.foodtruck.model.manager.managers.ArticleManager;

/**
 * @author Administrateur
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	// @Autowired
	private ArticleManager articleManager;

	private ApplicationContext ctx;

	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring.xml");
		articleManager = ctx
				.getBean("articleManagerImpl", ArticleManager.class);
	}

	@RequestMapping(value = "drinks", method = RequestMethod.GET)
	public String printDrinks(ModelMap model) {
		init();
		final List<Article> list = articleManager.getDrinkList();
		model.addAttribute("listVolumeDrink", VolumeDrink.values());
		model.addAttribute("listTypeDrink", TypeDrink.values());

		model.addAttribute("listdrink", list);
		model.addAttribute("drink", new Drink());

		return "drinks";
	}

	@RequestMapping(value = "meals", method = RequestMethod.GET)
	public String printMeals(ModelMap model) {
		init();
		final List<Article> list = articleManager.getMealList();
		model.addAttribute("listmeal", list);

		return "meals";
	}

	@RequestMapping(value = "adddrink", method = RequestMethod.GET)
	public String showDrink(@ModelAttribute("drink") Drink drink, ModelMap model) {
		init();
		return "adddrink";
	}

	@RequestMapping(value = "adddrink", method = RequestMethod.POST)
	public String addDrink(@ModelAttribute("drink") Drink drink, ModelMap model) {
		init();

		if (drink == null || drink.getName() == null
				|| drink.getDescription() == null || drink.getPrice() == null
				|| drink.getName().isEmpty()
				|| drink.getDescription().isEmpty()) {
			return "redirect:drinks";
		}

		articleManager.addDrink(drink);

		return "redirect:drinks";
	}
}