package com.raphasantos.BookStoreManager.resources;

import com.raphasantos.BookStoreManager.domain.Category;
import com.raphasantos.BookStoreManager.dtos.CategoryDTO;
import com.raphasantos.BookStoreManager.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "categories")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> list = categoryService.findAll();
        List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Category> insert(@RequestBody Category obj) {
        obj = categoryService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update (@PathVariable Long id, @RequestBody CategoryDTO objDTO){
        Category newObj = categoryService.update(id, objDTO);
        return ResponseEntity.ok().body(new CategoryDTO(newObj));
    }
}
