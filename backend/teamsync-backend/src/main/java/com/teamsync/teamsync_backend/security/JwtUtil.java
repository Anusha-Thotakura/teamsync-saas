package com.teamsync.teamsync_backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import com.teamsync.teamsync_backend.security.JwtUtil;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "mysecretkeymysecretkeymysecretkey";
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(KEY)
                .compact();
    }
}