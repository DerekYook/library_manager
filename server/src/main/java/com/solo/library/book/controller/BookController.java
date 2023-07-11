package com.solo.library.book.controller;

import com.solo.library.book.dto.BookDto;
import com.solo.library.book.entity.Book;
import com.solo.library.book.mapper.BookMapper;
import com.solo.library.book.repository.BookRepository;
import com.solo.library.book.service.BookService;
import java.util.List;
import javax.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@Validated
@Slf4j
public class BookController {
    private final static String BOOK_DEFAULT_URL = "/books";
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookMapper bookMapper, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity getBooks(@Positive @RequestParam int page){
        Page<Book> pageBooks = bookService.findBooks(page -1, 10);
        List<Book> books = pageBooks.getContent();
        return new ResponseEntity<>(
                new BookDto.MultiResponseDto<>(bookMapper.booksResponseDtoToBooks(books),
                        pageBooks), HttpStatus.OK);
    }
// Todo : 하나로 통합
//    @GetMapping("/books/search")
//    public ResponseEntity searchBooks(@RequestBody BookDto.Search search){
//        List<Book> bookList = bookService.searchBooks(search);
//        return new ResponseEntity<>(bookMapper.booksSearchDtoToBooks(bookList), HttpStatus.OK);
//    }
    @GetMapping("/books/search")
    public ResponseEntity searchTitle(@Positive @RequestParam int page, @RequestParam String title){
        Page<Book> pageBooks = bookService.searchTitle(page -1, 10, title);
        List<Book> books = pageBooks.getContent();
        return new ResponseEntity<>(new BookDto.MultiResponseDto<>(bookMapper.booksResponseDtoToBooks(books),pageBooks), HttpStatus.OK);
    }
}
