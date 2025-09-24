package com.sparta_msa.auth.core.application;

import com.sparta_msa.auth.core.domain.User;
import com.sparta_msa.auth.core.port.in.SignInUseCase;
import com.sparta_msa.auth.core.port.in.SignupUseCase;
import com.sparta_msa.auth.core.port.out.LoadUserPort;
import com.sparta_msa.auth.core.port.out.SaveUserPort;
import com.sparta_msa.auth.dto.UserRequestDto;
import com.sparta_msa.auth.dto.UserResponseDto;
import com.sparta_msa.auth.dto.UserSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class AuthService implements SignInUseCase, SignupUseCase {
    private final PasswordEncoder passwordEncoder;
    private final SaveUserPort saveUserPort;
    private final LoadUserPort loadUserPort;

    private User toEntity(UserRequestDto requestDto) {
        return User.builder()
                .username(requestDto.username())
                .password(passwordEncoder.encode(requestDto.password()))
                .nickname(requestDto.nickname())
                .role(requestDto.role())
                .build();
    }

    @Override
    public ResponseEntity<UserResponseDto> signUp(UserRequestDto requestDto) {
        return ResponseEntity
                .created(URI.create("temp"))
                .body(saveUserPort.saveUser(toEntity(requestDto)).toDto());
    }

    @Override
    public ResponseEntity<String> signIn(UserSignInDto signInDto) {
        User user = loadUserPort.loadUserByUsername(signInDto.username())
                .orElseThrow(() -> new IllegalArgumentException("invalid username"));

        if (!passwordEncoder.matches(signInDto.password(), user.getPasswordToValidate())) {
            throw new IllegalArgumentException("invalid password");
        }

        return ResponseEntity.ok("login success");
    }
}
