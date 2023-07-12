package com.solo.library.book.repository;

import com.solo.library.book.entity.Book;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookCustomRepository {

    Optional<Book> verifyBook();

    Page<Book> searchBooks(Pageable pageable, String title, String writer, String publisher);
//    Page<Book> searchTitle(Pageable pageable, String title);
}
