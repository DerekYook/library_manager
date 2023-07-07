package com.solo.library.book.service;

import com.solo.library.book.entity.Book;
import com.solo.library.book.mapper.BookMapper;
import com.solo.library.book.repository.BookRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Page<Book> findBooks(int page, int size){
        return bookRepository.findAll(PageRequest.of(page, size, Sort.by("title", "writer", "publisher").descending()));
    }

    public List<Book> searchBooks(int page, int size, String title, String writer, String publisher){
        return bookRepository.searchBooks(page, size, title, writer, publisher);
    }
}
