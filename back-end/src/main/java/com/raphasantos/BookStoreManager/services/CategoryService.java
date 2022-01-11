package com.raphasantos.BookStoreManager.services;

import com.raphasantos.BookStoreManager.domain.Category;
import com.raphasantos.BookStoreManager.repositories.CategoryRepository;
import com.raphasantos.BookStoreManager.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        List<Category> list = categoryRepository.findAll();
        return categoryRepository.findAll();
    }

    public Category findbyId(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo " + Category.class.getName()));
    }
}
