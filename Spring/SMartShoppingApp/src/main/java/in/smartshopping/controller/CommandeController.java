package in.smartshopping.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


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
	
//	@PutMapping("commande/{id}/update")
//	public void updateCommande(@RequestBody Commande commande, @PathVariable int id) {
//		commandeRepo.updateCommande(id, commande);
//	}
	
//	@PutMapping("/books")  
//	private Commande update(@RequestBody Commande books)   
//	{  
//		commandeRepo.getCommandeHavingMaxId(books);  
//	return books;  
//	} 
//	

//	@GetMapping("/books")  
//	private Commande update()   
//	{  
//		return commandeRepo.getCommandeHavingMaxId();
//	} 
	
	@GetMapping("/books/{id}/true")  
	private void update(@PathVariable int id)   
	{  
		commandeRepo.getCommandeHavingMaxId(id);
	} 
	
	@GetMapping("/books/{id}/false")  
	private void update1(@PathVariable int id)   
	{  
		commandeRepo.getCommandeHavingMaxId1(id);
	} 
	
	
	
	@PutMapping("/books")  
	private void update2()   
	{  
		commandeRepo.getCommandeHavingMaxId2();
	} 
	
	
	
	
	@GetMapping("/books8/{id}/true")  
	private void update8(@PathVariable int id)   
	{  
		commandeRepo.getCommandeHavingMaxId8(id);
	} 
	
	@GetMapping("/books8/{id}/false")  
	private void update18(@PathVariable int id)   
	{  
		commandeRepo.getCommandeHavingMaxId18(id);
	} 
	
	
	
	
	@GetMapping("/booksx/{id}/{id_liv}")  
	private void updatex(@PathVariable int id, @PathVariable int id_liv)   
	{  
		commandeRepo.getCommandeHavingMaxIdx(id, id_liv);
	} 
	
	@GetMapping("/books0/{id}")  
	private void update0(@PathVariable int id)   
	{  
		commandeRepo.getCommandeHavingMaxId0(id);
	} 
}
