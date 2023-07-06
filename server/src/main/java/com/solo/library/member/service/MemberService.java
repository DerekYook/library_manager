package com.solo.library.member.service;

import com.solo.library.exception.BusinessLogicException;
import com.solo.library.exception.ExceptionCode;
import com.solo.library.member.dto.MemberDto;
import com.solo.library.member.entitiy.Member;
import com.solo.library.member.mapper.MemberMapper;
import com.solo.library.member.repository.MemberRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Member createMember(Member member) {
        verifyExistMember(member.getNickName(), member.getPhone());
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    public void verifyExistMember(String nickName, String phone) {
        Optional<Member> member = memberRepository.verifyMember(nickName, phone);
        if (member.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }

    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);

        memberRepository.delete(findMember);
    }

    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    public Page<Member> findMembers(int page, int size){
//        return memberRepository.findAll(PageRequest.of(page, size, Sort.by("nickName").descending()));
        return memberRepository.findAll(PageRequest.of(page, size));
    }

}
