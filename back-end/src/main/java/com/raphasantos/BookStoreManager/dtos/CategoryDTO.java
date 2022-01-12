package com.raphasantos.BookStoreManager.dtos;

import com.raphasantos.BookStoreManager.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO implements Serializable {
    public Long id;

    @NotEmpty(message = "Need to be filled")
    @Length(min = 6, max = 51, message = "Minimum between 5 to 50 characters needed!")
    public String name;

    @NotEmpty(message = "Need to be filled")
    @Length(min = 6, max = 51, message = "Minimum between 5 to 50 characters needed!")
    public String description;

    public CategoryDTO(Category obj) {
        id = obj.getId();
        name = obj.getName();
        description = obj.getDescription();
    }
}
