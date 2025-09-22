package com.sparta_msa.auth.core.port.out;

import com.sparta_msa.auth.core.domain.User;

public interface SaveUserPort {
    User saveUser(User user);
}
