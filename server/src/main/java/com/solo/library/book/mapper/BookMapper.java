package com.solo.library.book.mapper;

import com.solo.library.book.dto.BookDto;
import com.solo.library.book.entity.Book;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    BookDto.Response bookResponseDtoToBook(Book book);
    @Autowired
    List<BookDto.Response> booksResponseDtoToBooks(List<Book> books);
}
