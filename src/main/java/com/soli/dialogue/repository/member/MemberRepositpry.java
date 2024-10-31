package com.soli.dialogue.repository.member;

import com.soli.dialogue.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepositpry extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

}
