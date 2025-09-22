package com.sparta_msa.auth.adapter.in.api;

import com.sparta_msa.auth.core.application.AuthService;
import com.sparta_msa.auth.core.port.in.SignInUseCase;
import com.sparta_msa.auth.core.port.in.SignupUseCase;
import com.sparta_msa.auth.dto.UserRequestDto;
import com.sparta_msa.auth.dto.UserResponseDto;
import com.sparta_msa.auth.dto.UserSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    private final SignupUseCase signupUseCase;
    private final SignInUseCase signInUseCase;

    @PostMapping("/signUp")
    private ResponseEntity<UserResponseDto> signUp(@RequestBody UserRequestDto requestDto) {
        return signupUseCase.signUp(requestDto);
    }

    @PostMapping("/signIn")
    private ResponseEntity<String> signIn(@RequestBody UserSignInDto signInDto) {
        return signInUseCase.signIn(signInDto);
    }
}
