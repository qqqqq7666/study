package com.sparta_msa.auth.adapter.out.persistence;

import com.sparta_msa.auth.core.domain.User;
import com.sparta_msa.auth.core.port.out.LoadUserPort;
import com.sparta_msa.auth.core.port.out.SaveUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements LoadUserPort, SaveUserPort {
    private final UserRepository userRepository;
    @Override
    public Optional<User> loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
