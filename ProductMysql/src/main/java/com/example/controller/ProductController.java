package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.Product;
import com.example.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@GetMapping(value = "/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		Optional<Product> pr = repo.findById(id);
		return pr.get();
	}

	@PostMapping(value = "/addProduct")
	public void saveProduct(@RequestBody Product prd) {
		repo.save(prd);
	}

	@DeleteMapping(value = "/deleteProduct/{id}")
	public void deleteProduct(@PathVariable Long id) {
		repo.deleteById(id);

	}

}
