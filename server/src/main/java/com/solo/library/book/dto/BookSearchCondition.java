package com.solo.library.book.dto;

import lombok.Data;

@Data
public class BookSearchCondition {
    private Long bookId;
    private String title;
    private String writer;
    private String publisher;
    private String libraryBook;
}
