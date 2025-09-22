package com.sparta_msa.auth.core.domain;

import com.sparta_msa.auth.dto.UserResponseDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String nickname;

    @Builder
    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public UserResponseDto toDto() {
        return UserResponseDto.builder()
                .username(username)
                .nickname(nickname)
                .build();
    }

    public String getPasswordToValidate() {
        return password;
    }
}
