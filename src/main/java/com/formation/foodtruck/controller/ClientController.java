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
@RequestMapping("/client")
public class ClientController {



	private ClientManager clientManager;
	private ApplicationContext ctx;

	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring.xml");
		clientManager = ctx.getBean("clientManagerImpl", ClientManager.class);

	}

	@RequestMapping(method = RequestMethod.GET)
	public String printClient(ModelMap model) {
		this.init();
		final List<Client> list = clientManager.getClientList();
		model.addAttribute("clientlist", list);
		final Client client = new Client();
		model.addAttribute("addclient", client);
		return "client";
	}

	@RequestMapping(value = "addclient", method = RequestMethod.GET)
	public String showClient(@ModelAttribute("addclient") Client client, ModelMap model) {
		this.init();
		return "client";
	}


	@RequestMapping(value = "addclient", method = RequestMethod.POST)
	public String AddClient(
			@ModelAttribute("addclient") Client client, ModelMap model) {
		this.init();
		if (client != null && client.getLastName() != null
				&& !client.getLastName().isEmpty() && client.getFirstName() != null
				&& !client.getFirstName().isEmpty()
				&& client.getMail() != null
				&& !client.getMail().isEmpty() && client.getPassword() != null
				&& !client.getPassword().isEmpty()) {
			clientManager.addClient(client);
			return "redirect:/client";
		}
		return "redirect:/client";
	}


	@RequestMapping("/update/{clientId}")
	public String UpdateClient(ModelMap model,
			@PathVariable("clientId") Integer clientId) throws SQLException {
		this.init();
		final Client client = clientManager.getClient(clientId);
		model.addAttribute("update", client);
		return "client";
	}


	public String handleFormModifClient(
			@ModelAttribute("clientUpdate") Client client,
			@PathVariable("clientId") Integer clientId, ModelMap model)
			throws BadAttributeValueExpException {
init();
		if (client != null && client.getLastName() != null

				&& !client.getLastName().isEmpty() && client.getFirstName() != null
				&& !client.getFirstName().isEmpty()
				&& client.getMail() != null
				&& !client.getMail().isEmpty() && client.getPassword() != null
				&& !client.getPassword().isEmpty()){

			client.setId(clientId);
			clientManager.updateClient(client);
			return "redirect:/client";
		}

		model.addAttribute("update", client);
		return "client";

	}

	@RequestMapping(value = "/delete/{clientId}", method = RequestMethod.GET)
	public String DeleteClientGet(
			@PathVariable("clientId") Integer clientId, ModelMap model) throws SQLException {
		this.init();
		final Client client = clientManager.getClient(clientId);
		clientManager.removeClient(client);
		return "redirect:/client";

	}

	@RequestMapping(value = "/delete/{clientId}", method = RequestMethod.POST)
	public String DeleteClientPost(
			@PathVariable("clientId") Integer clientId, ModelMap model) throws SQLException {
		this.init();
		final Client client = clientManager.getClient(clientId);
		if (clientId != null){
			clientManager.removeClient(client);
		}

		return "redirect:/client";

	}
}
