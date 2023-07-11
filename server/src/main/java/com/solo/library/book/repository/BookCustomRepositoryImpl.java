package com.solo.library.book.repository;

import static com.solo.library.book.entity.QBook.book;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solo.library.book.dto.BookDto;
import com.solo.library.book.entity.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
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

//    @Override
//    public List<Book> searchBooks(BookDto.Search search){
//        return jpaQueryFactory.selectFrom(book).where(orCon(search.getTitle(), search.getWriter(),
//                search.getPublisher())).fetch();
//    }
//    private BooleanExpression titleCon(String titleCond){
//        return titleCond != null ? book.title.contains(titleCond) : null;
//    }
//    private BooleanExpression writerCon(String writerCond){
//        return writerCond != null ? book.title.contains(writerCond) : null;
//    }
//    private BooleanExpression publisherCon(String publisherCond){
//        return publisherCond != null ? book.title.contains(publisherCond) : null;
//    }
//    private BooleanExpression orCon(String titleCond, String writerCond, String publisherCond){
//        return titleCon(titleCond).or(writerCon(writerCond)).or(publisherCon(publisherCond));
//    }
    @Override
    public Page<Book> searchTitle(Pageable pageable, String title){
        List<Book> content = jpaQueryFactory.selectFrom(book).where(book.title.contains(title)).offset(
                pageable.getOffset()).limit(pageable.getPageSize()).fetch();
        JPAQuery<Long> countQuery = jpaQueryFactory.select(book.count()).from(book).where(book.title.contains(title));
        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }
}
