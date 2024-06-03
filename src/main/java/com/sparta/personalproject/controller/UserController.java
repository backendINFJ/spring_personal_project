package com.sparta.personalproject.controller;

import com.sparta.personalproject.dto.UserRequestDto;
import com.sparta.personalproject.entity.User;
import com.sparta.personalproject.entity.UserRole;
import com.sparta.personalproject.jwt.JwtTokenProvider;
import com.sparta.personalproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @PostMapping("/join")
    public Long join(@RequestBody UserRequestDto userRequestDto) {
        User user = User.builder()
                .nickname(userRequestDto.getNickname()) // 수정: nickname 추가
                .username(userRequestDto.getUsername())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .roles(Collections.singletonList(UserRole.ROLE_USER.name()))
                .build();
        userRepository.save(user);
        return user.getId();
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequestDto userRequestDto) {
        User member = userRepository.findByUsername(userRequestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 nickname 입니다."));
        if (!passwordEncoder.matches(userRequestDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }
}