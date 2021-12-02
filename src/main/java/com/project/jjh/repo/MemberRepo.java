package com.project.jjh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.jjh.entity.Member;
public interface MemberRepo extends JpaRepository<Member, Long> {

    Member findByMemberId(String memberId);


}
