package com.test.msblog.service;

import com.test.msblog.dto.JoinRequestDto;
import com.test.msblog.entity.User;
import com.test.msblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(JoinRequestDto joinRequestDto) {
        if (userRepository.existsByUsername(joinRequestDto.getUsername())) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }

        String tmpRole = "ROLE_USER";
        userRepository.save(new User(joinRequestDto.getUsername(), bCryptPasswordEncoder.encode(joinRequestDto.getPassword()), tmpRole));
    }
}
