package com.project.jjh.service;

import com.project.jjh.entity.Member;
import com.project.jjh.repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    MemberRepo memberRepo;

  public MemberService(MemberRepo memberRepo){

        this.memberRepo = memberRepo;
   }

   public Page<Member> getMemberList(Pageable pageable){
       int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작

       // 정렬
       pageable = PageRequest.of(page, 10,Sort.by("mNo").descending()); //new Sort(Sort.Direction.DESC, "mNo"));

       return memberRepo.findAll(pageable);
   }

   public Member saveMember(Member member){
       System.out.println("222222222222");
       System.out.println("----------member------------" + member);
       System.out.println("결과//////////////////////////");
        return memberRepo.save(member);

   }



   public void validateDuplicateMember(Member member){
        Member findMember = memberRepo.findByMemberId(member.getMemberId());
       System.out.println("findMember========= "+findMember);
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");


        }

   }



}
