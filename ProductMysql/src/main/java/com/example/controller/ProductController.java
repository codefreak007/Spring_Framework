package com.example.controller;

import java.util.List;

import java.util.Optional;

import com.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private ProductService serv;

	@GetMapping(value = "/product/{id}")
	public Product getProduct(@PathVariable Long id) {
	    log.debug("Product id" +id);
		return serv.getProduct(id);
	}
	
	@GetMapping(value = "products")
	public Iterable<Product> getProducts() {
		 return serv.getProducts();
	}
	
	@GetMapping(value = "/products/{name}")
	public Iterable<Product> getAllProducts(@PathVariable String name) {
		return serv.getAllProductsByName(name);
	}

	@PostMapping(value = "addProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product prd) {
		return new ResponseEntity<Product>(serv.saveProduct(prd),HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteProduct/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		serv.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/deleteAll")
	public void  deleteProduct() {
		serv.deleteProducts();
	}
	
	@PostMapping(value = "updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product prt) {
		return new ResponseEntity<Product>(serv.updateProduct(id,prt),HttpStatus.OK);
	}

}
