package com.soli.dialogue.dto.member;

import com.soli.dialogue.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MemberRegisterRequest {

    @NotBlank
    @Email(message = "이메일 형식을 확인해주세요.")
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()._-])[a-zA-Z0-9!@#$%^&*()._-]{8,20}",
            message = "영어, 숫자, 특수문자를 포함하여 8자 이상 20자 이하로 입력해주세요")
    private String password;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$",
            message = "2자 이상 16자 이하로 입력해주세요.")
    private String nickname;

    private Role role;
}
