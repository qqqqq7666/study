package com.sparta_msa.auth.domain;

import lombok.Builder;

@Builder
public record UserResponseDto(String username, String nickname) { }
