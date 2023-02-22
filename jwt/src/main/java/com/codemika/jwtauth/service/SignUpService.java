package com.codemika.jwtauth.service;

import com.codemika.jwtauth.dto.RqCreateUser;
import com.codemika.jwtauth.dto.RsCommonUser;
import com.codemika.jwtauth.entity.UserEntity;
import com.codemika.jwtauth.repository.UserRepository;
import com.codemika.jwtauth.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository repository;
    private final JwtUtil jwtUtil;

    public ResponseEntity<?> signUpUserService(RqCreateUser rq){
        UserEntity user  = new UserEntity()
                .setFirstName(rq.getName())
                .setLastName(rq.getSurname())
                .setEmail(rq.getEmail());

        user = repository.save(user);

        RsCommonUser response = new RsCommonUser()
                .setId(user.getId())
                .setName(user.getFirstName())
                .setSurname(user.getLastName())
                .setEmail(user.getEmail())
                .setToken(jwtUtil.generateToken());


        return ResponseEntity.ok(response);
    }
}

