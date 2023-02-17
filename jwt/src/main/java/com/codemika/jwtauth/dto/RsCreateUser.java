package com.codemika.jwtauth.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RsCreateUser {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String token;
}
