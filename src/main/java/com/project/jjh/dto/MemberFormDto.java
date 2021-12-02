package com.project.jjh.dto;

import lombok.Data;

@Data
public class MemberFormDto {

    private Long mNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberAddress;
    private String memberPhone;
    private String memberEmail;

}
