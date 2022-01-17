package com.raphasantos.BookStoreManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class BookStoreManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreManagerApplication.class, args);
	}

}
