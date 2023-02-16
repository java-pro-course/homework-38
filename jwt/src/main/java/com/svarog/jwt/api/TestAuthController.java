package com.svarog.jwt.api;

import com.svarog.jwt.until.JwtUntil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestAuthController {
    private final JwtUntil jwtUntil;
    @GetMapping("test-user")
    public ResponseEntity<?> testIsUserAuth(@RequestHeader("Authorization") String token){
        if (jwtUntil.validateToken(token)) return ResponseEntity.ok("Token valid!😊");

        return ResponseEntity.ok("Token invalid!😨");
    }
}
