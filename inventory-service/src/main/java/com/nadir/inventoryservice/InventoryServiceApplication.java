package com.nadir.inventoryservice;

import com.nadir.inventoryservice.enitities.Product;
import com.nadir.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			Stream.of(
					new Product(null, "Computer Desktop Hp", 900),
					new Product(null, "Printer Epson", 80),
					new Product(null, "MacBook Pro Laptop", 1800)
			).forEach(productRepository::save);
			productRepository.findAll().forEach(System.out::println);
		};
	}

}
