package com.codemika.jwtauth.api;

import com.codemika.jwtauth.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestAuthController {

    private final JwtUtil jwtUtil;

    @GetMapping("validate-token")
    public ResponseEntity<?> testIsUserAuth(@RequestHeader("Authorisation") String token){
        if(jwtUtil.validateToken(token)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("token valid!");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("token INVALID");
    }
}
