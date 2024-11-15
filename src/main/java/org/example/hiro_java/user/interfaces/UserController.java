package org.example.hiro_java.user.interfaces;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.hiro_java.user.domain.User;
import org.example.hiro_java.user.domain.UserService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
    @PostMapping("/login")
    public UserResponseDto login(@RequestBody UserRequestDto userDto, HttpServletResponse response) {
        User user = userService.login(userDto.getUserId(), userDto.getPassword());

        String newToken = userService.makeToken(user.getUserId());
        Cookie cookie = new Cookie("access_token", newToken);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setMaxAge(24 * 60);
        response.addCookie(cookie);

        return new UserResponseDto(user);
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userDtp, HttpServletResponse response) {
        User user = userService.register(userDtp.getUserId(), userDtp.getPassword(), userDtp.getName());

        return new UserResponseDto(user);
    }

    @GetMapping("/auth")
    public Boolean auth(@CookieValue(value = "access_token", defaultValue = "") String token, HttpServletResponse response) {
        User user = userService.validateToken(token);
        response.addHeader("x_user", user.getUserId());
        response.addHeader("x_username", user.getName());

        String newToken = userService.makeToken(user.getUserId());
        Cookie cookie = new Cookie("access_token", newToken);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setMaxAge(24 * 60);
        response.addCookie(cookie);

        return true;
    }
}
