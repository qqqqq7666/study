package com.sparta_msa.auth.domain;

import lombok.Builder;

@Builder
public record UserRequestDto(String username, String password, String nickname) {
}
