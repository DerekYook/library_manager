package com.solo.library.member.repository;

import com.solo.library.member.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Long, Member> {

}
