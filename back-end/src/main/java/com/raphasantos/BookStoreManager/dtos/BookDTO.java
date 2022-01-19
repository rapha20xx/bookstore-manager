package com.raphasantos.BookStoreManager.dtos;

import com.raphasantos.BookStoreManager.domain.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class BookDTO {
    private Long id;

    @NotEmpty(message = "Need to be filled")
    @Length(min = 3, max = 2000001, message = "Minimum between 5 to 2.000.000 characters needed!")
    private String title;

    public BookDTO(Book obj) {
        id = obj.getId();
        title = obj.getTitle();
    }
}
