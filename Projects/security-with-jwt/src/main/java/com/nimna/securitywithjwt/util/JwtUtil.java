package com.nimna.securitywithjwt.util;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private long TOKEN_VALIDITY;

    private String getUserNameFromT0ken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public  <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
    };

}
