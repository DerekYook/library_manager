package com.solo.library.member.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Column(length = 10, nullable = false, updatable = false, unique = true)
    private String nickName;

    @Column(length = 15, nullable = false, unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    private Enum status;

    @Column(length = 50, nullable = false)
    private String libraryMember;

}
