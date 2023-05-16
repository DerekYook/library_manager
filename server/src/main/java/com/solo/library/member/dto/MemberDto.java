package com.solo.library.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class post{
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

}
