package in.smartshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.smartshopping.model.Commande;
import in.smartshopping.repo.CommandeRepo;

@RestController
public class CommandeController {
	
	@Autowired
	private CommandeRepo commandeRepo;
	
	@GetMapping("/commande/list")
	public List<Commande> getAllData() {

		return commandeRepo.findAll();
	}

	@GetMapping("/commande/{id}")
	public Optional<Commande> getDataById(@PathVariable int id) {

		return commandeRepo.findById(id);
	}
}
