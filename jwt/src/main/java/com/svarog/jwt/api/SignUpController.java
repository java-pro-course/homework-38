package com.svarog.jwt.api;

import com.svarog.jwt.dto.CreateUser;
import com.svarog.jwt.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignUpController {
    private final SignUpService service;

    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody CreateUser createUser){
        return service.signUp(createUser);
    }
}
