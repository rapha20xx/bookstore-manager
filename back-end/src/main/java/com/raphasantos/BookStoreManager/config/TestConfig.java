package com.raphasantos.BookStoreManager.config;

import com.raphasantos.BookStoreManager.domain.Book;
import com.raphasantos.BookStoreManager.domain.Category;
import com.raphasantos.BookStoreManager.repositories.BookRepository;
import com.raphasantos.BookStoreManager.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Tech", "Learn about technologies");

        Book bk1 = new Book(null, "JavaScript - The Fun Parts", "Douglas Crockford", "Most programming languages contain good and bad parts", cat1);

        categoryRepository.saveAll(Arrays.asList(cat1));
        bookRepository.saveAll(Arrays.asList(bk1));
    }
}
