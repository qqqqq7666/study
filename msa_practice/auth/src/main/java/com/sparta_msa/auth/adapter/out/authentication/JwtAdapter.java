package com.sparta_msa.auth.adapter.out.authentication;

import com.sparta_msa.auth.core.domain.UserRole;
import com.sparta_msa.auth.core.port.out.GenerateTokenPort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtAdapter implements GenerateTokenPort {
    @Value("${service.jwt.secret-key}")
    private String secretKey;
    @Value("${service.jwt.access-expiration}")
    private long expiration;

    @Override
    public String generateToken(String username, UserRole role) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
        return Jwts.builder()
                .signWith(key)
                .subject(username)
                .claim("role", role.name())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .compact();
    }
}
