package org.example.hiro_java.user.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hiro_java.user.domain.User;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "user_info")
@NoArgsConstructor
@Getter
public class UserEntity {
    @Id
    String userId;
    String password;
    String name;
    Date registerAt;

    public UserEntity(User user) {
        this.userId = user.getUserId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.registerAt = user.getRegisterAt();
    }

    public User toDomain() {
        return new User(this.userId, this.password, this.name, this.registerAt);
    }
}
