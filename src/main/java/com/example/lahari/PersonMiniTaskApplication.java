package com.example.lahari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching 
public class PersonMiniTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonMiniTaskApplication.class, args);
	}

}
