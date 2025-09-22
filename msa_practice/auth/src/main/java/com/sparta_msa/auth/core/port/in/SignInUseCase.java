package com.sparta_msa.auth.core.port.in;

import com.sparta_msa.auth.dto.UserSignInDto;
import org.springframework.http.ResponseEntity;

public interface SignInUseCase {
    ResponseEntity<String> signIn(UserSignInDto signInDto);
}
