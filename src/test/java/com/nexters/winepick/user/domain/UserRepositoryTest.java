package com.nexters.winepick.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.nexters.winepick.config.TestConfig;
import com.nexters.winepick.constant.PersonalityType;
import com.nexters.winepick.user.exception.UserInvalidAccessTokenException;
import com.nexters.winepick.user.repository.UserRepository;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(TestConfig.class)
public class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  private User user;

  @BeforeEach
  void init() {
    user = userRepository.save(User.builder()
        .accessToken("accessToken")
        .personalityType(PersonalityType.A)
        .likes(new ArrayList<>())
        .build());
  }

  @Test
  void 사용자_생성() {
    assertThat(user.getAccessToken()).isEqualTo("accessToken");
    assertThat(user.getPersonalityType()).isEqualTo(PersonalityType.A);
    assertThat(user.getLikes().size()).isEqualTo(0);
    assertThat(user.getId()).isEqualTo(2);
  }

  @Test
  void 사용자_정보_조회() {
    user = userRepository.findUserByAccessToken("accessToken")
        .orElseThrow(() -> new UserInvalidAccessTokenException("accessToken"));

    assertThat(user.getId()).isNotEqualTo(1);
  }
}

