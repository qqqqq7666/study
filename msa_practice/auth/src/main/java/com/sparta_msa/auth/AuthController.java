package com.sparta_msa.auth;

import com.sparta_msa.auth.domain.UserRequestDto;
import com.sparta_msa.auth.domain.UserResponseDto;
import com.sparta_msa.auth.domain.UserSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signUp")
    private ResponseEntity<UserResponseDto> signUp(UserRequestDto requestDto) {
        return authService.signUp(requestDto);
    }

    @PostMapping("/signIn")
    private ResponseEntity<String> signIn(UserSignInDto signInDto) {
        return authService.signIn(signInDto);
    }
}
