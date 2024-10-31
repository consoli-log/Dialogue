package com.soli.dialogue.controller.member;

import com.soli.dialogue.dto.member.MemberRegisterRequest;
import com.soli.dialogue.service.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public String register(@RequestBody @Valid MemberRegisterRequest request) {

        memberService.Register(request);

        return "redirect:/";
    }





}
