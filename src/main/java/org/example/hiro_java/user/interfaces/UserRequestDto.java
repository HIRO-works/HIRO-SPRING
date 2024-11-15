package org.example.hiro_java.user.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequestDto {
    String userId;
    String password;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Register extends UserRequestDto {
        String name;
    }
}
