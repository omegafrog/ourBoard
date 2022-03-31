package com.board.main;

import com.board.main.repository.BoardRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainApplication {
	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
