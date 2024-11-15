package org.example.hiro_java.user.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import java.util.Date;

@Getter
@AllArgsConstructor
public class User {

    String userId;
    String password;
    String name;
    Date registerAt;

    public User(String userId, String password, String name) {
        this.userId = userId;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.name = name;
        this.registerAt = new Date();
    }

    public boolean validatePassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }

}
