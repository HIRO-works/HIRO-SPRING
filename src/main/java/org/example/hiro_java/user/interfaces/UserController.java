package org.example.hiro_java.user.interfaces;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
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
    public UserResponseDto.Token login(@RequestBody UserRequestDto userDto, HttpServletResponse response) {
        User user = userService.login(userDto.getUserId(), userDto.getPassword());

        String newToken = userService.makeToken(user.getUserId());

        return new UserResponseDto.Token(user, newToken);
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto.Register userDtp) {
        User user = userService.register(userDtp.getUserId(), userDtp.getPassword(), userDtp.getName());

        return new UserResponseDto(user);
    }

    @GetMapping("/auth")
    public Boolean auth(@RequestHeader(value = "access_token") String token, HttpServletRequest req, HttpServletResponse response) {
        System.out.println(req.getHeader("access_token"));
        User user = userService.validateToken(token);
        response.addHeader("x_user", user.getUserId());
        response.addHeader("x_username", user.getName());

        return true;
    }
}
