package com.nexters.winepick.like.domain;

import static com.nexters.winepick.user.domain.User.Gender.FEMALE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

import com.nexters.winepick.like.domain.Likes.UseYn;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.domain.UserRepository;
import com.nexters.winepick.wine.domain.Wine;
import com.nexters.winepick.wine.domain.WineRepository;
import com.nexters.winepick.wine.exception.WineNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class LikesRepositoryTest {

  @Autowired
  LikesRepository likesRepository;

  @Autowired
  WineRepository wineRepository;

}
