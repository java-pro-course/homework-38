package com.svarog.jwt.api;

import com.svarog.jwt.dto.LoginUser;
import com.svarog.jwt.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("login-user")
    public ResponseEntity<?> loginUser(@RequestBody LoginUser user){
        return loginService.loginUser(user);
    }
}
