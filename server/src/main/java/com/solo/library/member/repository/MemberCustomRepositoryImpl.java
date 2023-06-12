package com.solo.library.member.repository;

import static com.solo.library.member.entitiy.QMember.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solo.library.member.entitiy.Member;
import com.solo.library.member.entitiy.QMember;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MemberCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Member> verifyMember(String nickName, String phone) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(member)
                .where(member.nickName.eq(nickName).or(member.phone.eq(phone))).fetchOne());
    }
}
