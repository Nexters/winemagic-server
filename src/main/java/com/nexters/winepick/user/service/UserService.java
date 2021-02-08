package com.nexters.winepick.user.service;

import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.exception.UserNotFoundException;
import com.nexters.winepick.user.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;

    public User createUserEntity(User user) {
        return this.userRepository.save(user);
    }

    public User getUserByIdAndAccessToken(Integer userId, String accessToken) {
        return this.userRepository.findUserByIdAndAccessToken(userId, accessToken)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}
