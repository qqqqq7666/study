package com.sparta_msa.auth.core.port.in;

import com.sparta_msa.auth.dto.UserRequestDto;
import com.sparta_msa.auth.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;

public interface SignupUseCase {
    ResponseEntity<UserResponseDto> signUp(UserRequestDto requestDto);
}
