package com.nexters.winepick.user.domain;

import static com.nexters.winepick.constant.GenderType.FEMALE;
import static org.assertj.core.api.BDDAssertions.then;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @Test
  void save_user() {
    User user = User.builder()
        .email("6230nana")
        .ageRange(20)
        .gender(FEMALE)
        .build();

    User result = userRepository.save(user);

    then(result)
        .hasFieldOrPropertyWithValue("email", "6230nana")
        .hasFieldOrPropertyWithValue("ageRange", 20)
        .hasFieldOrPropertyWithValue("gender", FEMALE);

  }


}
