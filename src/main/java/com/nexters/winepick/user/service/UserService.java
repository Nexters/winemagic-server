package com.nexters.winepick.user.service;

import com.nexters.winepick.like.domain.LikesRepository;
import com.nexters.winepick.user.api.dto.RenewAccessTokenDTO;
import com.nexters.winepick.user.api.dto.UserDTO;
import com.nexters.winepick.user.api.dto.UserResponse;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.exception.UserInvalidAccessTokenException;
import com.nexters.winepick.user.exception.UserNotFoundException;
import com.nexters.winepick.user.repository.UserRepository;
import java.util.ArrayList;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;
    private final LikesRepository likesRepository;

    public UserResponse createUserEntity(UserDTO userDTO) {
        User user = userRepository.save(User.builder()
            .accessToken(userDTO.getAccessToken())
            .personalityType(userDTO.getPersonalityType())
            .likes(new ArrayList<>())
            .build());
        return UserResponse.of(user);
    }

    public UserResponse getUserByIdAndAccessToken(Integer userId, String accessToken) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        if (!user.getAccessToken().equals(accessToken)) {
            throw new UserInvalidAccessTokenException(accessToken);
        } else {
            user.setLikes(likesRepository.findLikesByUserIdAndUseYn(userId));
            return UserResponse.of(user);
        }
    }

    public User updateUserAccessToken(RenewAccessTokenDTO tokenDTO) {
        User user = this.userRepository.findUserByAccessToken(tokenDTO.getExpiredAccessToken())
                .orElseThrow(() -> new UserInvalidAccessTokenException(tokenDTO.getExpiredAccessToken()));

        user.setAccessToken(tokenDTO.getNewAccessToken());

        return this.userRepository.save(user);
    }
}
