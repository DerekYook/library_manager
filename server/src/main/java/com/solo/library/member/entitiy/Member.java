package com.solo.library.member.entitiy;

import com.solo.library.exception.BusinessLogicException;
import com.solo.library.exception.ExceptionCode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 10, nullable = false, updatable = false)
    private String nickName;

    @Column(length = 15, nullable = false)
    private String phone;

    @Column(nullable = false)
    private MemberStatus memberStatus = MemberStatus.Active;

    @Column(length = 50, nullable = false)
    private String libraryMember;

    public enum MemberStatus {
        Active,
        Inactive;
    }

    public Member(String email, String nickName, String phone, String libraryMember) {
        this.email = email;
        this.nickName = nickName;
        this.phone = phone;
        this.libraryMember = libraryMember;
    }
}
