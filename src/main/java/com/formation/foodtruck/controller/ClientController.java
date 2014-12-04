package com.formation.foodtruck.controller;

import java.sql.SQLException;
import java.util.List;

import javax.management.BadAttributeValueExpException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.foodtruck.model.entity.Client;
import com.formation.foodtruck.model.manager.managers.ClientManager;

@Controller
@RequestMapping("/clientList")
public class ClientController {

	// @Autowired
	private ClientManager clientManager;
	private ApplicationContext ctx;

	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring.xml");
		clientManager = ctx.getBean("clientManagerImpl", ClientManager.class);

	}

	@RequestMapping(method = RequestMethod.GET)
	public String printClient(ModelMap model) {

		final List<Client> list = clientManager.getClientList();
		model.addAttribute("clientlist", list);
		return "client";
	}

	@RequestMapping("/addClient")
	public String showFormAddClient(ModelMap model) {

		final Client client = new Client();
		model.addAttribute("addClient", client);
		return "addClient";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String handleFormAddClient(
			@ModelAttribute("addClient") Client client, ModelMap model) {

		if (client != null && client.getLastName() != null
				&& !client.getLastName().isEmpty()
				&& client.getFirstName() != null
				&& !client.getFirstName().isEmpty()) {
			clientManager.addClient(client);
			return "redirect:/clientList";
		}

		model.addAttribute("addClient", client);
		return "addClient";

	}

	@RequestMapping("/clientUpdate/{clientId}")
	public String showFormModifClient(ModelMap model,
			@PathVariable("clientId") Integer clientId) throws SQLException {

		final Client client = clientManager.getClient(clientId);
		model.addAttribute("clientUpdate", client);
		return "clientUpdate";
	}

	@RequestMapping(value = "/edit/{clientId}", method = RequestMethod.POST)
	public String handleFormModifClient(
			@ModelAttribute("clientUpdate") Client client,
			@PathVariable("clientId") Integer clientId, ModelMap model)
			throws BadAttributeValueExpException {

		if (client != null && client.getLastName() != null
				&& !client.getLastName().isEmpty()
				&& client.getFirstName() != null
				&& !client.getFirstName().isEmpty()) {

			client.setId(clientId);
			clientManager.updateClient(client);
			return "redirect:/client";
		}

		model.addAttribute("clientUpdate", client);
		return "clientUpdate";

	}

	@RequestMapping(value = "/delete/{clientId}", method = RequestMethod.GET)
	public String handleFormSupprClient(
			@PathVariable("clientId") Integer clientId, ModelMap model) {

		clientManager.removeClient(null);
		return "redirect:/client";

	}
}
