package in.smartshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.smartshopping.model.Product;
import in.smartshopping.repo.ProductRepo;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("/product/list")
	public List<Product> getAllData() {

		return productRepo.findAll();
	}

	@GetMapping("/product/{id}")
	public Optional<Product> getDataById(@PathVariable int id) {

		return productRepo.findById(id);
	}
}
