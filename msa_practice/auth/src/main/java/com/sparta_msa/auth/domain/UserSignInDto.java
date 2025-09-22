package com.sparta_msa.auth.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
public record UserSignInDto(String username, String password) { }
