package com.raphasantos.BookStoreManager.services;

import com.raphasantos.BookStoreManager.domain.Book;
import com.raphasantos.BookStoreManager.domain.Category;
import com.raphasantos.BookStoreManager.repositories.BookRepository;
import com.raphasantos.BookStoreManager.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;

    public void instantiatingDbService() {
        Category cat1 = new Category(null, "Tech", "Learn about technologies");
        Category cat2 = new Category(null, "Culinary", "Learn about cooking");
        Category cat3 = new Category(null, "Health", "Health Care");

        Book bk1 = new Book(null, "JavaScript - The Fun Parts", "Douglas Crockford", "Most programming languages contain good and bad parts", cat1);
        Book bk2 = new Book(null, "TCM Foods, Cooking With The Five Elements", "J. Lei Russell", "Used in Traditional Chinese Medicine Colleges and Universities internationally since 2007", cat2);
        Book bk3 = new Book(null, "Lifespan: Why We Age―and Why We Don’t Have To", "David A. Sinclair ", "Care about your health and don't age soon.", cat3);
        Book bk4 = new Book(null, "Ng-Book 2: The Complete Book on Angular 2", "Nate Murray ", "What if you could master the entire framework ", cat1);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        bookRepository.saveAll(Arrays.asList(bk1, bk2, bk3, bk4));
    }
}
