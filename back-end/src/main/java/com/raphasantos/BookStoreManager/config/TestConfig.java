package com.raphasantos.BookStoreManager.config;

import com.raphasantos.BookStoreManager.domain.Book;
import com.raphasantos.BookStoreManager.domain.Category;
import com.raphasantos.BookStoreManager.repositories.BookRepository;
import com.raphasantos.BookStoreManager.repositories.CategoryRepository;
import com.raphasantos.BookStoreManager.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    DbService dbService;

    @Bean
    public void instantiatingDbService() {
        dbService.instantiatingDbService();
    }
}
