package com.solo.library.member.service;

import com.solo.library.exception.BusinessLogicException;
import com.solo.library.exception.ExceptionCode;
import com.solo.library.member.dto.MemberDto;
import com.solo.library.member.entitiy.Member;
import com.solo.library.member.mapper.MemberMapper;
import com.solo.library.member.repository.MemberRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public Member createMember(MemberDto.Post requestBody){
        //내용채우기
        verifyExistMember(requestBody);
        Member member = new Member();
        member.setNickName(requestBody.getNickName());
        member.setEmail(requestBody.getEmail());
        member.setPhone(requestBody.getPhone());
        member.setMemberStatus(member.getMemberStatus());
        member.setLibraryMember(requestBody.getLibraryMember());
        return memberRepository.save(member);
    }

    public void verifyExistMember(MemberDto.Post requestBody){
        Optional<Member> member = memberRepository.verifyMember(requestBody.getNickName(),
                requestBody.getPhone());
        if(member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

}
