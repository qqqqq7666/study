package com.sparta_msa.auth.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(String username, String nickname) { }
