package com.project.jjh.member;

import com.project.jjh.entity.Member;
import com.project.jjh.repo.MemberRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    MemberRepo memberRepo;

    @Test
    public void testInsertMember(){

        for(int i = 100; i<201; i++){
            Member member = Member.builder().memberId("test" + i).memberPw("test" + i)
                            .memberName("회원" + i).memberAddress("test" + i)
                            .memberPhone("010"+i).memberEmail("test" + i + "@test.com").build();

            memberRepo.save(member);


        }

    }
}
