package com.solo.library.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @Column(nullable = false)
    private String title;

    @Column(length = 20, nullable = false)
    private String writer;

    @Column(length = 20, nullable = false)
    private String publisher;

    @Column(length = 50, nullable = false)
    private String libraryBook;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus bookStatus = BookStatus.Returned;

    public enum BookStatus{
        Returned("도서 대출 가능"),
        Loaned("도서 대출 불가"),
        Out("도서 페기");

        @Getter
        private String status;

        BookStatus(String status) {
            this.status = status;
        }
    }

    public Book(String title, String writer, String publisher, String libraryBook) {
        this.title = title;
        this.writer = writer;
        this.publisher = publisher;
        this.libraryBook = libraryBook;
    }
}
