package org.example.hiro_java.user.domain;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.example.hiro_java.global.exceptions.CustomException;
import org.example.hiro_java.user.infra.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import jakarta.servlet.http.Cookie;

@Service
@RequiredArgsConstructor
public class UserService {
    @Value("${hiro.jwt.secret}")
    String JWT_SECRET;

    final UserRepository userRepository;
    final static long TOKEN_EXPIRATION_TIME = 1000L * 60 * 30; // 30분
    final static String TOKEN_NAME = "access_token";

    public User login(String userId, String password) {
        User user = userRepository.getUserByUserId(userId);
        var success = user.validatePassword(password);
        if(!success) throw new CustomException(401, "Invalid password");

        return user;
    }

    public User register(String userId, String password, String name) {
        try{
            userRepository.getUserByUserId(userId);
        } catch(CustomException e) {
            if(e.getCode() != 404) throw e;

            return userRepository.saveUser(new User(userId, password, name));
        }

        throw new CustomException(400, "User already exists");
    }

    public String makeToken(String userId) {
        var secretKey = new SecretKeySpec(JWT_SECRET.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        String token = Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();

        return token;
    }

    public User validateToken(String token) {
        if(token == null || token.isEmpty()) throw new CustomException(401, "No Token!");

        var secretKey = new SecretKeySpec(JWT_SECRET.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        String userId = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        if(userId == null) throw new CustomException(401, "Invalid Token!");
        return userRepository.getUserByUserId(userId);
    }
}
