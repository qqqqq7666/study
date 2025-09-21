package client_auth;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signIn")
    public ResponseEntity<AuthResponse> createAuthToken(@RequestParam String userId) {
        return ResponseEntity.ok(AuthResponse.builder()
                .access_token(authService.createAccessToken(userId))
                .build());
    }

    @Builder
    @Getter
    private static class AuthResponse {
        private String access_token;
    }
}
