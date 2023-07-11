package com.solo.library.book.repository;

import com.solo.library.book.dto.BookDto;
import com.solo.library.book.entity.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookCustomRepository {
    Optional<Book> verifyBook();
    //Page<Book> searchBooks(Pageable pageable);
//    List<Book> searchBooks(BookDto.Search search);
    Page<Book> searchTitle(Pageable pageable, String title);
}
