package com.ust.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductapiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductapiClientApplication.class, args);
	}
	@Bean
	public RestTemplate newTemplate() {
		return new RestTemplate();
	}

}
