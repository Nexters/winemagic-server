package com.nexters.winepick.user.service;

import com.nexters.winepick.user.api.dto.RenewAccessTokenDTO;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.exception.UserInvalidAccessTokenException;
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
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        if (!user.getAccessToken().equals(accessToken)) {
            throw new UserInvalidAccessTokenException(accessToken);
        } else {
            return user;
        }
    }

    public User updateUserAccessToken(RenewAccessTokenDTO tokenDTO) {
        User user = this.userRepository.findUserByAccessToken(tokenDTO.getExpiredAccessToken())
                .orElseThrow(() -> new UserInvalidAccessTokenException(tokenDTO.getExpiredAccessToken()));

        user.setAccessToken(tokenDTO.getNewAccessToken());

        return this.userRepository.save(user);
    }
}
