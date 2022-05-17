package com.board.main.domain.user.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class SignupForm {
    @NotEmpty(message ="id값은 필수사항 입니다.")
    private String email;
    @NotEmpty(message ="비밀번호 값은 필수사항 입니다.")
    private String password;
    @NotEmpty(message ="닉네임 값은 필수사항 입니다.")
    private String userName;




}
