package com.project.jjh.controller;

import com.project.jjh.dto.MemberFormDto;
import com.project.jjh.entity.Member;
import com.project.jjh.repo.MemberRepo;
import com.project.jjh.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberRepo memberRepo;

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/memberJoin")
    public String memberJoin(Model model){

        model.addAttribute("memberFormDto", new MemberFormDto());

        System.out.println("============회원가입 페이지 진입================");
        return "/member/memberJoin";
    }

    @PostMapping("/memberJoin")
    public String memberJoinForm(Member member){

        memberRepo.save(member);

//        System.out.println("----------memberFormDto------------" + memberFormDto);
//        Member member = Member.createMember(memberFormDto, passwordEncoder);
//        memberService.saveMember(member);

        System.out.println("============회원가입 가입 완료================");
        return "redirect:/";

    }

    @GetMapping("/memberList")
    public String memberList(@PageableDefault Pageable pageable, Model model){

        Page<Member> memberList = memberRepo.findAll(pageable);

        model.addAttribute("memberList", memberList);
        System.out.println("============회원 목록 출력 완료================");

        return "/member/memberList";
    }






}
