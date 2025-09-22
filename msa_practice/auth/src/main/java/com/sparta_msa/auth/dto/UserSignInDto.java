package com.sparta_msa.auth.dto;

import lombok.Builder;

@Builder
public record UserSignInDto(String username, String password) { }
