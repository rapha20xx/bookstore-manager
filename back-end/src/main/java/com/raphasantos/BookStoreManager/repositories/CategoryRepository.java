package com.raphasantos.BookStoreManager.repositories;

import com.raphasantos.BookStoreManager.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
