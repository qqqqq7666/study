package com.sparta_msa.auth.dto;

import com.sparta_msa.auth.core.domain.UserRole;
import lombok.Builder;

@Builder
public record UserResponseDto(String username,
                              String nickname,
                              UserRole role) { }
