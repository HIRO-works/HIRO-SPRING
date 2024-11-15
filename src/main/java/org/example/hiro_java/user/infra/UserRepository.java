package org.example.hiro_java.user.infra;

import lombok.RequiredArgsConstructor;
import org.example.hiro_java.global.exceptions.CustomException;
import org.example.hiro_java.user.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class UserRepository {
    final UserJpaRepository userJpaRepository;

    public User saveUser(User user) {
        return userJpaRepository.save(new UserEntity(user)).toDomain();
    }

    public User getUserByUserId(String userId) {
        var entity = userJpaRepository.findById(userId);
        if (entity.isEmpty()) throw new CustomException(404, "User not found");

        return entity.get().toDomain();
    }
}
