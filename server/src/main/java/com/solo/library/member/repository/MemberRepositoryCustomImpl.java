package com.solo.library.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solo.library.member.entitiy.Member;
import com.solo.library.member.entitiy.QMember;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private static final QMember member = QMember.member;

    @Override
    public Optional<Member> verifyMember(String nickName, String phone) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(member)
                .where(member.nickName.eq(nickName).and(member.phone.eq(phone))).fetchOne());
    }
}
