package com.soli.dialogue.service.member;

import com.soli.dialogue.dto.member.MemberRegisterRequest;
import com.soli.dialogue.entity.Member;
import com.soli.dialogue.enums.Role;
import com.soli.dialogue.repository.member.MemberRepositpry;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepositpry memberRepositpry;

    public String Register(MemberRegisterRequest request) {
        Optional<Member> findMember = memberRepositpry.findByEmail(request.getEmail());
        if (findMember.isPresent()) {
            return "이미 가입된 Email 입니다.";
        }

        Member member = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .role(request.getRole())
                .build();


        memberRepositpry.save(member);

        return "가입되었습니다.";
    }
}
