package com.solo.library.book.repository;

import static com.solo.library.book.entity.QBook.book;
import static org.springframework.util.StringUtils.hasText;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solo.library.book.entity.Book;
import com.solo.library.book.entity.QBook;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    public BookCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Book> verifyBook(){
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
    public Page<Book> searchBooks(SearchCondition condition, Pageable pageable){
        List<Book> books = jpaQueryFactory.selectFrom(book).where(titleEq(condition.getTitle()), writerEq(condition.getWriter()), publisherEq(condition.getPublisher())).offset(
                pageable.getOffset()).limit(pageable.getPageSize()).fetch();
        JPAQuery<Book> countQuery = jpaQueryFactory.selectFrom(book).where(titleEq(condition.getTitle()), writerEq(condition.getWriter()), publisherEq(condition.getPublisher()));
        return PageableExecutionUtils.getPage(books, pageable, () -> countQuery.fetchCount());
    }

    private BooleanExpression titleEq(String title){
        return hasText(title) ? book.title.eq(title) : null;
    }
    private BooleanExpression writerEq(String writer){
        return hasText(writer) ? book.writer.eq(writer) : null;
    }
    private BooleanExpression publisherEq(String publisher){
        return hasText(publisher) ? book.publisher.eq(publisher) : null;
    }
}
