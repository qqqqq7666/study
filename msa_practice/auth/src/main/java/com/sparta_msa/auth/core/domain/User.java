package com.sparta_msa.auth.core.domain;

import com.sparta_msa.auth.dto.UserResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public User(String username, String password, String nickname, UserRole role) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    public UserResponseDto toDto() {
        return UserResponseDto.builder()
                .username(username)
                .nickname(nickname)
                .role(role)
                .build();
    }

    public String getPasswordToValidate() {
        return password;
    }
}
