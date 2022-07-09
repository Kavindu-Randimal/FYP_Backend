package com.agro.Final.Year.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class FinalYearProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalYearProjectApplication.class, args);
	}

}
