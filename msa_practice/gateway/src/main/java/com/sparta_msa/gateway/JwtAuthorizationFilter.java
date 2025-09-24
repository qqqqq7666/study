package com.sparta_msa.gateway;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;

@Slf4j
@Component
public class JwtAuthorizationFilter implements GlobalFilter, Ordered {
    @Value("${service.jwt.secret-key}")
    private String secretKey;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        if (path.startsWith("/api/v1/orders")) {
            if (exchange.getRequest().getMethod() == HttpMethod.PATCH) {
                String token = extractToken(exchange);
                if(validateRole(token))
                    return chain.filter(exchange);
                else{
                    log.error("invalid token");
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            }
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }

    private String extractToken(ServerWebExchange exchange) {
        String headerVal = exchange.getRequest().getHeaders().getFirst("Authorization");
        assert headerVal != null;
        if (!headerVal.startsWith("Bearer"))
            throw new SecurityException("invalid token");

        return headerVal.substring(7);
    }

    private boolean validateRole(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
        String role = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);

        log.info("user role: {}", role);

        return role.equals("MANAGER");
    }
}
