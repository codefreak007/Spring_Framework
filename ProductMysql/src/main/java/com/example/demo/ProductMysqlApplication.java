package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.controller.ProductController;
import com.example.repository.ProductRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.repository")
@EntityScan(basePackages = "com.example.repository")
@ComponentScan(basePackages = "com.example")
public class ProductMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMysqlApplication.class, args);
	}

}
