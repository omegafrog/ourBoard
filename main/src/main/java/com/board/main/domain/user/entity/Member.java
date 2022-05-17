package com.board.main.domain.user.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private String email;
    private String userName;
    private String password;

}
