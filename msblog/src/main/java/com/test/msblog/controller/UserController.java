package com.test.msblog.controller;


import com.test.msblog.dto.JoinRequestDto;
import com.test.msblog.dto.JoinResponseDto;
import com.test.msblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/join")
    public ResponseEntity<JoinResponseDto> join(JoinRequestDto joinRequestDto) {
        userService.join(joinRequestDto);
        return ResponseEntity.ok(new JoinResponseDto("회원가입이 완료되었습니다.", HttpStatus.OK.value()));
    }



}