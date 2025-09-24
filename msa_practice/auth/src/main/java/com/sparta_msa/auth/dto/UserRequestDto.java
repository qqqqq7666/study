package com.sparta_msa.auth.dto;

import com.sparta_msa.auth.core.domain.UserRole;
import lombok.Builder;

@Builder
public record UserRequestDto(String username,
                             String password,
                             String nickname,
                             UserRole role) {
}
