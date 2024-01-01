package com.example.demo;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;


@SpringBootApplication
public class HelloApplication {

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.parse("512KB"));
		factory.setMaxRequestSize(DataSize.parse("512KB"));
		return factory.createMultipartConfig();
	}
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
