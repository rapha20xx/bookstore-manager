package com.raphasantos.BookStoreManager.services;

import com.raphasantos.BookStoreManager.domain.Book;
import com.raphasantos.BookStoreManager.dtos.BookDTO;
import com.raphasantos.BookStoreManager.repositories.BookRepository;
import com.raphasantos.BookStoreManager.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryService categoryService;

    public List<Book> findAll(Long id_cat) {
        categoryService.findById(id_cat);
        return bookRepository.findAllbyCategory(id_cat);
    }

    public Book findById(Long id) {
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo " + Book.class.getName()));
    }

    public Book insert(Book obj) {
        obj.setId(null);
        return bookRepository.save(obj);
    }


    public Book update(Long id, BookDTO objDTO) {
        Book obj = findById(id);
        obj.setTitle(objDTO.getTitle());
        return bookRepository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            bookRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.raphasantos.BookStoreManager.services.exceptions.DataIntegrityViolationException("Book can not be deleted! There are books associated");
        }

    }
}
