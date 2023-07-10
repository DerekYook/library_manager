package com.solo.library.book.repository;

import com.solo.library.book.dto.BookSearchCondition;
import com.solo.library.book.entity.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookCustomRepository {
    Optional<Book> verifyBook();
    //Page<Book> searchBooks(Pageable pageable);
    Page<Book> searchBooks(BookSearchCondition condition, Pageable pageable);
}
