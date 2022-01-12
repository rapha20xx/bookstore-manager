package com.raphasantos.BookStoreManager.services;

import com.raphasantos.BookStoreManager.domain.Category;
import com.raphasantos.BookStoreManager.dtos.CategoryDTO;
import com.raphasantos.BookStoreManager.repositories.CategoryRepository;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo " + Category.class.getName()));
    }

    public Category insert(Category obj) {
        obj.setId(null);
        return categoryRepository.save(obj);
    }


    public Category update(Long id, CategoryDTO objDTO) {
        Category obj = findById(id);
        obj.setName(objDTO.getName());
        obj.setDescription(objDTO.getDescription());
        return categoryRepository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.raphasantos.BookStoreManager.services.exceptions.DataIntegrityViolationException("Category can not be deleted! There are books associated");
        }

    }
}
