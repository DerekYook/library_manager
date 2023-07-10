package com.solo.library.book.repository;

import com.solo.library.book.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long>, BookCustomRepository {
    @Query(value = "SELECT * FROM book WHERE title like :title or writer like :writer or publisher like :publisher", nativeQuery = true)
    List<Book> searchBooks2(String title, String writer, String publisher);
}