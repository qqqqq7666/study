package com.sparta_msa.gateway;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;

@Slf4j
@Component
public class JwtAuthenticationFilter implements GlobalFilter, Ordered {

    @Value("${service.jwt.secret-key}")
    private String secretKey;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        if (path.equals("/api/v1/orders")) {
            String token = extractToken(exchange);
            if (validateToken(token))
                return chain.filter(exchange);
            else {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                log.error("invalid token!!!!");
                return exchange.getResponse().setComplete();
            }
        } else
            return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return 0;
    }

    private String extractToken(ServerWebExchange exchange) {
        String headerVal = exchange.getRequest().getHeaders().getFirst("Authorization");
        log.info("token: {}", headerVal);
        if (!headerVal.startsWith("Bearer") || headerVal == null)
            throw new SecurityException("invalid token");

        return headerVal.substring(7);
    }

    private boolean validateToken(String token) {
        if (token == null)
            return false;
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);

            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }


    }
}
