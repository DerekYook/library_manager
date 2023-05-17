package com.solo.library.member.mapper;

import com.solo.library.member.dto.MemberDto;
import com.solo.library.member.entitiy.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberMapper {
    Member memberPostDtoToMember(MemberDto.Post requestBody);
}
