package com.project.jjh.entity;

import com.project.jjh.constant.Role;
import com.project.jjh.dto.MemberFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member") // 테이블 명
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long mNo;

    @Column(unique = true)
    String memberId;

    String memberPw;
    String memberName;
    String memberAddress;
    String memberPhone;
    String memberEmail;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        System.out.println("333333333333333");

        Member member = new Member();

        member.setMNo(266L);
        member.setMemberId(memberFormDto.getMemberId());
        member.setMemberName(memberFormDto.getMemberName());
        member.setMemberAddress(memberFormDto.getMemberAddress());
        member.setMemberPhone(memberFormDto.getMemberPhone());
        member.setMemberEmail(memberFormDto.getMemberEmail());
        System.out.println("중간===============================");
        String password = passwordEncoder.encode(memberFormDto.getMemberPw());
        member.setMemberPw(password);
        member.setRole(Role.USER);
        System.out.println("member내......................" + member);
        return member;



    }

}