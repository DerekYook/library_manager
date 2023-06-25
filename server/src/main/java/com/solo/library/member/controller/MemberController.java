package com.solo.library.member.controller;

import com.solo.library.member.dto.MemberDto;
import com.solo.library.member.entitiy.Member;
import com.solo.library.member.mapper.MemberMapper;
import com.solo.library.member.service.MemberService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@Validated
@Slf4j
public class MemberController {

    private final static String MEMBER_DEFAULT_URL = "/members";
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {
        Member member = memberMapper.memberPostDtoToMember(requestBody);
        Member createdMember = memberService.createMember(member);

//        return new ResponseEntity<>(new MemberDto.SingleResponseDto<>(memberMapper.memberResponseDtoToMember(createdMember)), HttpStatus.OK);
        return new ResponseEntity<>(memberMapper.memberResponseDtoToMember(createdMember), HttpStatus.CREATED);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page){
//            , @Positive @RequestParam int size) {
        Page<Member> pageMembers = memberService.findMembers(page-1,10);
        List<Member> members = pageMembers.getContent();
        return new ResponseEntity<>( new MemberDto.MultiResponseDto<>(memberMapper.membersResponseDtoToMembers(members), pageMembers), HttpStatus.OK);
    }

}
