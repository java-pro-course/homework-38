package com.example.jwt.api;

import com.example.jwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestAuthController {

    private final JwtUtil jwtUtil;

    @GetMapping("validate-token")
    public ResponseEntity<?> testIsUserAuth(@RequestHeader("Authorization") String token) {
       if(jwtUtil.validateToken(token)){
           return ResponseEntity.ok("token valid");
       }
       return ResponseEntity.ok("token INVALID");
     }
}
