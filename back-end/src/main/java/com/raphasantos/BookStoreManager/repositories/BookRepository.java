package com.raphasantos.BookStoreManager.repositories;

import com.raphasantos.BookStoreManager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
