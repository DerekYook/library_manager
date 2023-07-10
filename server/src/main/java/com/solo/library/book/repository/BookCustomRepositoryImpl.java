package com.solo.library.book.repository;

import static com.solo.library.book.entity.QBook.book;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solo.library.book.dto.BookSearchCondition;
import com.solo.library.book.entity.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public BookCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Book> verifyBook() {
        return null;
    }

//    @Override
//    public Page<Book> searchBooks(Pageable pageable){
//        QBook book = QBook.book;
//        QueryResults<Book> bookList = jpaQueryFactory.selectFrom(book)
//                .where(book.title.eq(title)
//                        .and(book.writer.eq(writer))
//                        .and(book.publisher.eq(publisher)))
//                .fetchCount();
//
//        List<Book> bookList = jpaQueryFactory.selectFrom(book)
//                .where(book.title.eq(title)
//                        .and(book.writer.eq(writer))
//                        .and(book.publisher.eq(publisher)))
//                .offset(page * size)
//                .limit(size)
//                .fetch();
//
//        return bookList;
//    }

    @Override
    public Page<Book> searchBooks(BookSearchCondition condition, Pageable pageable){
        QueryResults<Book> results = jpaQueryFactory.selectFrom(book).where(book.title.contains(
                condition.getTitle()), book.writer.contains(condition.getWriter()), book.publisher.contains(
                condition.getPublisher())).offset(
                pageable.getOffset()).limit(pageable.getPageSize()).fetchResults();

        List<Book> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
