package com.raphasantos.BookStoreManager.repositories;

import com.raphasantos.BookStoreManager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT obj FROM Book obj WHERE obj.category.id = :id_cat ORDER BY title")
    List<Book>findAllbyCategory(@Param(value = "id_cat")Long id_cat);
}
