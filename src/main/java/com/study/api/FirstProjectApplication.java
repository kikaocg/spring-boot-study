package com.study.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.study.api.utils.PasswordUtils;

@SpringBootApplication
public class FirstProjectApplication {

	@Value("${paginacao.qtd.por_pagina}")
	private int qntPorPagina;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Spring boot started successfully");
		};
	}
	
}
