package com.gotrybe.tour;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TourServiceInGoTrybeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourServiceInGoTrybeApplication.class, args);
	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
}
