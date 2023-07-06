package com.solo.library.member.dto;

import com.solo.library.member.entitiy.Member;
import com.solo.library.member.entitiy.Member.MemberStatus;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

public class MemberDto {

    @Getter
    @AllArgsConstructor
    public static class Post {

        @NotBlank
        @Email(message = "이메일 형식에 맞게 작성해주세요.")
        private String email;

        @NotBlank(message = "성함은 필수입니다.")
        private String nickName;

        @NotBlank
        @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
                message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
        private String phone;

        @NotBlank(message = "등록할 도서관이 필요합니다.")
        private String libraryMember;
    }

    @Getter
    //@AllArgsConstructor
    //@RequiredArgsConstructor
    public static class Response {

        private long memberId;
        private String email;
        private String nickName;
        private String phone;
        private String libraryMember;
        private Member.MemberStatus memberStatus;

        public Response(long memberId, String email, String nickName, String phone,
                String libraryMember,
                MemberStatus memberStatus) {
            this.memberId = memberId;
            this.email = email;
            this.nickName = nickName;
            this.phone = phone;
            this.libraryMember = libraryMember;
            this.memberStatus = memberStatus;
        }
    }


    @Getter
    @AllArgsConstructor
    public static class SingleResponseDto<T> {

        private T data;

    }

    @Getter
    public static class MultiResponseDto<T> {

        private List<T> data;
        private PageInfo pageInfo;

        public MultiResponseDto(List<T> data, Page page) {
            this.data = data;
            this.pageInfo = new PageInfo(page.getNumber() + 1, page.getSize(),
//            this.pageInfo = new PageInfo(page.getNumber() + 1, 10,
                    page.getTotalElements(),
                    page.getTotalPages());
        }
    }

    @Getter
    @AllArgsConstructor
    public static class PageInfo {
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;
    }

}
