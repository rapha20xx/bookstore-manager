package com.raphasantos.BookStoreManager.dtos;

import com.raphasantos.BookStoreManager.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO implements Serializable {
    private Long id;

    @NotNull(message = "Name need to be filled")
    @Size(min = 3, max = 30, message = "Minimum between 3 to 30 characters needed!")
    private String name;

    @NotNull(message = "Need to be filled")
    @Size(min = 5, max = 50, message = "Minimum between 5 to 50 characters needed!")
    private String description;

    public CategoryDTO(Category obj) {
        id = obj.getId();
        name = obj.getName();
        description = obj.getDescription();
    }
}
