package com.solo.library.book.controller;

import com.solo.library.book.dto.BookDto;
import com.solo.library.book.entity.Book;
import com.solo.library.book.mapper.BookMapper;
import com.solo.library.book.service.BookService;
import java.util.List;
import javax.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public ResponseEntity getBooks(@Positive @RequestParam int page){
        Page<Book> pageBooks = bookService.findBooks(page -1, 10);
        List<Book> books = pageBooks.getContent();
        return new ResponseEntity<>(
                new BookDto.MultiResponseDto<>(bookMapper.booksResponseDtoToBooks(books),
                        pageBooks), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity searchBooks(@Positive @RequestParam int page, @RequestParam String title, @RequestParam String writer, @RequestParam String publisher){
//        Page<Book> pageBooks = bookService.searchBooks(page -1, 10, title, writer, publisher);
//        List<Book> books = pageBooks.getContent();
//        return new ResponseEntity<>(
//                new BookDto.MultiResponseDto<>(bookMapper.booksResponseDtoToBooks(books),
//                        pageBooks), HttpStatus.OK);
        List<Book> bookList = bookService.searchBooks(page, 10, title, writer, publisher);
        return new ResponseEntity<>(
                new BookDto.SingleResponseDto<>(bookMapper.booksResponseDtoToBooks(bookList)), HttpStatus.OK);
    }
}
