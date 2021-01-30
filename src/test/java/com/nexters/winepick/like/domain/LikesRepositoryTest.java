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

  @Test
  void save() {

//    Likes likes = likesRepository.findLikesByUserIdAndWineId(1, 1);
//    assertThat(likes.getUserId()).isEqualTo(1);
//    assertThat(likes.getWine().getId()).isEqualTo(1);

    Wine wine = wineRepository.findWineById(3)
        .orElseThrow(() -> new WineNotFoundException(3));

    Likes like = Likes.builder()
        .userId(1)
        .wine(wine)
        .useYn(UseYn.Y)
        .build();
    likesRepository.save(like);

    then(like)
        .hasFieldOrPropertyWithValue("userId", 1)
        .hasFieldOrPropertyWithValue("useYn", UseYn.Y);

  }
}
