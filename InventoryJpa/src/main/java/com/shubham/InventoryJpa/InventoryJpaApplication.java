package com.shubham.InventoryJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class InventoryJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryJpaApplication.class, args);
	}

}
