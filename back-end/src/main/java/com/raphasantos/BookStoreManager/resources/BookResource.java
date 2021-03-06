package com.raphasantos.BookStoreManager.resources;

import com.raphasantos.BookStoreManager.domain.Book;
import com.raphasantos.BookStoreManager.dtos.BookDTO;
import com.raphasantos.BookStoreManager.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
@CrossOrigin("*")
public class BookResource {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Long id_cat) {
        List<Book> list = bookService.findAll(id_cat);
        List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book obj = bookService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Book> insert(@RequestParam(value = "category", defaultValue = "0") Long id_cat, @RequestBody Book obj) {
        Book newObj = bookService.insert(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/books/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Long id, @Valid @RequestBody BookDTO objDTO) {
        Book newObj = bookService.update(id, objDTO);
        return ResponseEntity.ok().body(new BookDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
