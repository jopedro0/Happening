package br.com.Hapenning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HapenningApplication {

	public static void main(String[] args) {
		SpringApplication.run(HapenningApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialization(){
		return args -> {
			System.out.println("olá mundo");
		};
	}
}
