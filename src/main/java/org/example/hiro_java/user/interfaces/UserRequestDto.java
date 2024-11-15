package org.example.hiro_java.user.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequestDto {
    String name;
    String userId;
    String password;
}
