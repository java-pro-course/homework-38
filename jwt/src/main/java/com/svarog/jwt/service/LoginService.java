package com.svarog.jwt.service;

import com.svarog.jwt.dto.LoginUser;
import com.svarog.jwt.dto.RsCommonUser;
import com.svarog.jwt.entity.UserEntity;
import com.svarog.jwt.repository.UserRepository;
import com.svarog.jwt.until.JwtUntil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final JwtUntil jwtUntil;

    public ResponseEntity<?> loginUser(LoginUser rq){
        Optional<UserEntity> user = userRepository.findByEmail(rq.getEmail());
        if(!user.isPresent()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("The user does not exist!");
        }
        if (!rq.getPassword().equals(user.get().getPassword())){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The password is incorrect!");
        }
        String newToken = jwtUntil.generateToken();

        RsCommonUser response = new RsCommonUser()
                .setId(user.get().getId())
                .setName(user.get().getName())
                .setSurname(user.get().getSurname())
                .setEmail(user.get().getEmail())
                .setPassword(user.get().getPassword())
                .setToken(newToken);
        return ResponseEntity.ok(response);
    }
}
