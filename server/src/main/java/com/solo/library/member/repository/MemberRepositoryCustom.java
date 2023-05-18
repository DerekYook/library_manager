package com.solo.library.member.repository;

import com.solo.library.member.entitiy.Member;
import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> verifyMember(String nickName, String phone);
}
