package com.solo.library.member.mapper;

import com.solo.library.member.dto.MemberDto;
import com.solo.library.member.entitiy.Member;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    @Autowired
    Member memberPostDtoToMember(MemberDto.Post requestBody);

    MemberDto.Response memberResponseDtoToMember(Member member);

    //Member memberResponseDtoToMember(Member member);
    @Autowired
    List<MemberDto.Response> membersResponseDtoToMembers(List<Member> members);

}
