package com.raphasantos.BookStoreManager.dtos;

import com.raphasantos.BookStoreManager.domain.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookDTO {
    private Long id;
    private String title;

    public BookDTO(Book obj) {
        id = obj.getId();
        title = obj.getTitle();
    }
}
