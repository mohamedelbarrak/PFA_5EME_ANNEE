package in.smartshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.smartshopping.model.LignePanierCommande;
import in.smartshopping.model.Product;
import in.smartshopping.repo.LignePanierCommandeRepo;
import in.smartshopping.repo.ProductRepo;

@RestController
public class LignePanierCommandeController {
	
	@Autowired
	private LignePanierCommandeRepo lignePanierCommandeRepo;
	
	@GetMapping("/lignePanierCommande/list")
	public List<LignePanierCommande> getAllData() {

		return lignePanierCommandeRepo.findAll();
	}

	@GetMapping("/lignePanierCommande/{id}")
	public Optional<LignePanierCommande> getDataById(@PathVariable int id) {

		return lignePanierCommandeRepo.findById(id);
	}
	
	@GetMapping("/lignePanierCommande/commande/{id}")
	public List<LignePanierCommande> getDataByIdCom(@PathVariable int id) {

		return lignePanierCommandeRepo.findByidCom(id);
	}
}
