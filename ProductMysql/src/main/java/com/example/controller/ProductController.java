package com.example.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.Product;
import com.example.repository.ProductRepository;
@CrossOrigin("*")
@RestController
public class ProductController {

	Logger log=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductRepository repo;

	@GetMapping(value = "/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		Optional<Product> pr = repo.findById(id);
		return pr.get();
	}
	
	@GetMapping(value = "products")
	public Iterable<Product> getProducts() {
		 return repo.findAll();
	}
	
	@GetMapping(value = "products/{name}")
	public Iterable<Product> getAllProducts(@PathVariable String name) {
		 return repo.findAllByName(name);
	}

	@PostMapping(value = "addProduct")
	public Product saveProduct(@RequestBody Product prd) {
		return repo.save(prd);
	}

	@DeleteMapping(value = "/deleteProduct/{id}")
	public void deleteProduct(@PathVariable Long id) {
		repo.deleteById(id);

	}
	
	@DeleteMapping(value = "/deleteAll")
	public void deleteProduct() {
		repo.deleteAll();

	}

}
