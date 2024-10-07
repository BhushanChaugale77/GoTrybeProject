package com.xpointers.gotrybe;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentServiceInGoTrybeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceInGoTrybeApplication.class, args);
	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}	
}
