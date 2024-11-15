package org.example.hiro_java.user.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hiro_java.user.domain.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDto {
    String name;
    String userId;

    public UserResponseDto(User user) {
        this.name = user.getName();
        this.userId = user.getUserId();
    }
}
