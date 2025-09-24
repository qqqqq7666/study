package com.sparta_msa.auth.core.port.out;

import com.sparta_msa.auth.core.domain.UserRole;

public interface GenerateTokenPort {
    String generateToken(String username, UserRole role);
}
