package com.nadir.customerservice;

import com.nadir.customerservice.entities.Customer;
import com.nadir.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			Stream.of(
					new Customer(null, "ENSET", "contact@enset-media.ma"),
					new Customer(null, "FSTM", "contact@fstm.ma"),
					new Customer(null, "ENSAM", "contact@ensam.ma")
			).forEach(customerRepository::save);
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
