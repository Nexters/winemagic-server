package com.nexters.winepick.user.api.dto;

import com.nexters.winepick.constant.PersonalityType;
import com.nexters.winepick.user.domain.User;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

  private Integer id;

  private BigInteger userId;

  private PersonalityType personality;

  private String accessToken;

  private Integer likes;

  public static UserResponse of(User user) {
    return new UserResponse(user.getId(), user.getUserId(), user.getPersonalityType(),
        user.getAccessToken(), user.getLikes().size());
  }
}
