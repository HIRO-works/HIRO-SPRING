package org.example.hiro_java.user.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user")
public class UserController {
    @PostMapping("/login")
    public String login() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/register")
    public String register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/auth")
    public Boolean auth() {
        return true;
    }
}
