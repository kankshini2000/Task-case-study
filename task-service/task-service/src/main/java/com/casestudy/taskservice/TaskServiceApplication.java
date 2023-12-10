package com.casestudy.taskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class TaskServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build(); 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
	}

}
