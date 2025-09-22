package com.sparta_msa.auth;

import com.sparta_msa.auth.domain.User;
import com.sparta_msa.auth.domain.UserRequestDto;
import com.sparta_msa.auth.domain.UserResponseDto;
import com.sparta_msa.auth.domain.UserSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private User toEntity(UserRequestDto requestDto) {
        return User.builder()
                .username(requestDto.username())
                .password(passwordEncoder.encode(requestDto.password()))
                .nickname(requestDto.nickname())
                .build();
    }

    public ResponseEntity<UserResponseDto> signUp(UserRequestDto requestDto) {
        return ResponseEntity
                .created(URI.create("temp"))
                .body(userRepository.save(toEntity(requestDto)).toDto());
    }

    public ResponseEntity<String> signIn(UserSignInDto signInDto) {
        User user = userRepository.findByUsername(signInDto.username())
                .orElseThrow(() -> new IllegalArgumentException("invalid username"));

        if (passwordEncoder.matches(signInDto.password(), user.getPasswordToValidate())) {
            throw new IllegalArgumentException("invalid password");
        }

        return ResponseEntity.ok("login success");
    }
}
