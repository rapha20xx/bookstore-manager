package com.raphasantos.BookStoreManager.dtos;

import com.raphasantos.BookStoreManager.domain.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CategoryDTO implements Serializable {
    public Long id;
    public String name;
    public String description;

    public CategoryDTO(Category obj) {
        id = obj.getId();
        name = obj.getName();
        description = obj.getDescription();
    }
}
