package com.sparta_msa.auth.dto;

import lombok.Builder;

@Builder
public record UserRequestDto(String username, String password, String nickname) {
}
