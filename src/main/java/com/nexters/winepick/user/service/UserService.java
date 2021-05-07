package com.nexters.winepick.user.service;

import com.nexters.winepick.like.domain.LikesRepository;
import com.nexters.winepick.user.api.dto.UserDTO;
import com.nexters.winepick.user.api.dto.UserResponse;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.exception.UserInvalidAccessTokenException;
import com.nexters.winepick.user.exception.UserNotFoundException;
import com.nexters.winepick.user.repository.UserRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final LikesRepository likesRepository;

  public UserResponse createUserEntity(UserDTO userDTO) {
    User user = userRepository.findUserByUserId(userDTO.getUserId());
    if (ObjectUtils.isEmpty(user)) {
      user = userRepository.save(User.builder()
          .accessToken(userDTO.getAccessToken())
          .userId(userDTO.getUserId())
          .personalityType(userDTO.getPersonalityType())
          .likes(new ArrayList<>())
          .build());
    }
    return UserResponse.of(user);
  }

  public UserResponse getUserByIdAndAccessToken(Integer userId, String accessToken) {
    User user = this.userRepository.findById(userId)
        .orElseThrow(() -> new UserNotFoundException(userId));
    if (!user.getAccessToken().equals(accessToken)) {
      throw new UserInvalidAccessTokenException(accessToken);
    } else {
      user.setLikes(likesRepository.findLikesByUserIdAndUseYn(userId));
      return UserResponse.of(user);
    }
  }

  public User updateUserEntity(String accessToken, UserDTO userDTO) {
    User user = this.userRepository.findUserByAccessToken(accessToken)
        .orElseThrow(() -> new UserInvalidAccessTokenException(accessToken));

    user.setAccessToken(userDTO.getAccessToken());
    user.setPersonalityType(userDTO.getPersonalityType());

    return user;
  }
}
