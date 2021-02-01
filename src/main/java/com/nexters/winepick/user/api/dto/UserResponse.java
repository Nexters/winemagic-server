package com.nexters.winepick.user.api.dto;

import com.nexters.winepick.base.PersonalityType;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.domain.User.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

  private Integer id;

  private String email;

  private String nickname;

  private int ageRange;

  private Gender gender;

  private PersonalityType personality;

  public static UserResponse of(User user) {
    return new UserResponse(user.getId(), user.getEmail(), user.getNickname(), user.getAgeRange(),
        user.getGender(), user.getPersonalityType());
  }
}
