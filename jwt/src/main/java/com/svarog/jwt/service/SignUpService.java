package com.svarog.jwt.service;

import com.svarog.jwt.dto.CreateUser;
import com.svarog.jwt.dto.RsCreateUser;
import com.svarog.jwt.entity.UserEntity;
import com.svarog.jwt.repository.UserRepository;
import com.svarog.jwt.until.JwtUntil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository repository;
    private final JwtUntil jwtUntil;

    public ResponseEntity<?> signUp(CreateUser createUser) {
        UserEntity user = new UserEntity()
                .setName(createUser.getName())
                .setSurname(createUser.getSurname())
                .setEmail(createUser.getEmail())
                .setPassword(createUser.getPassword());

        user = repository.save(user);

        RsCreateUser rsCreateUser = new RsCreateUser()
                .setId(user.getId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setToken(jwtUntil.generateToken());
        return ResponseEntity.ok(rsCreateUser);
    }
}
