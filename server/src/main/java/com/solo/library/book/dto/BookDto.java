package com.solo.library.book.dto;

import com.solo.library.book.entity.Book;
import com.solo.library.book.entity.Book.BookStatus;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

public class BookDto {

    @Getter
    public static class Response {

        private long bookId;
        private String title;
        private String writer;
        private String publisher;
        private String libraryBook;
        private Book.BookStatus bookStatus;

        public Response(long bookId, String title, String writer, String publisher,
                String libraryBook, BookStatus bookStatus) {
            this.bookId = bookId;
            this.title = title;
            this.writer = writer;
            this.publisher = publisher;
            this.libraryBook = libraryBook;
            this.bookStatus = bookStatus;
        }
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class SingleResponseDto<T> {

        private T data;

    }

    @Getter
    public static class MultiResponseDto<T> {

        private List<T> data;
        private PageInfo pageInfo;

        public MultiResponseDto(List<T> data, Page page) {
            this.data = data;
            this.pageInfo = new PageInfo(page.getNumber() + 1, page.getSize(),
                    page.getTotalElements(),
                    page.getTotalPages());
        }
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PageInfo {

        private int page;
        private int size;
        private long totalElements;
        private int totalPages;
    }

//    @Getter
//    public static class Search{
//        private String title;
//        private String writer;
//        private String publisher;
//
//        public Search(String title, String writer, String publisher) {
//            this.title = title;
//            this.writer = writer;
//            this.publisher = publisher;
//        }
//    }
}
