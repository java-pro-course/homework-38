package com.svarog.jwt.until;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUntil {
    public String generateToken(){
        long nowMill = System.currentTimeMillis();
        long expMill = nowMill + 1_000_000_000_000_000L;
        Date exp = new Date(expMill);

        return Jwts.builder()
                .setIssuedAt(exp)
                .signWith(SignatureAlgorithm.HS512, "secret")
                .compact();
    }
    public boolean validateToken(final String token){
        boolean isValid = false;
        try{
            Jwts.parser().setSigningKey("secret").parseClaimsJws(token);
            isValid = true;
        } catch (RuntimeException e){
            log.error(e.getMessage());
        }
        return isValid;
    }
}
