package com.solo.library.member.repository;

import static com.solo.library.member.entitiy.QMember.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solo.library.member.entitiy.Member;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MemberCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Member> verifyMember(String nickName, String phone, String libraryMember) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(member)
                .where(member.nickName.eq(nickName).and(member.phone.eq(phone))
                        .and(member.libraryMember.eq(libraryMember))).fetchOne());
    }
}
