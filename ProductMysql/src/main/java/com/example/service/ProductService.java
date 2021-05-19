package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.repository.Product;
import com.example.repository.ProductRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product getProduct(Long id) {
        return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("There is no such object"));
    }

    public Iterable<Product> getProducts() {
        return repo.findAll();
    }

    public Iterable<Product> getAllProductsByName(String name) {
        return repo.findAllByName(name);
    }

    public Product saveProduct(Product prd) {
        return repo.save(prd);
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }

    public void  deleteProducts() {
        repo.deleteAll();
    }

    public Product updateProduct(Long id, Product prt) {
        Optional<Product> pr = repo.findById(id);
        Product p=pr.get();
        p.setName(prt.getName());
        p.setColor(prt.getColor());
        p.setCategory(prt.getCategory());
        return repo.save(p);
    }

}
