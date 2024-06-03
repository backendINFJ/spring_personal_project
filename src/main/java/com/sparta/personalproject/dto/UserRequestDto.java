package com.sparta.personalproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    private String nickname;
    private String username;
    private String password;
}
