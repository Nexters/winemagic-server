package com.nexters.winepick.wine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.nexters.winepick.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(TestConfig.class)
public class WineRepositoryTest {

  @Autowired
  private WineRepository wineRepository;

  @Test
  void 와인_전체_조회() {
    assertThat(wineRepository.findAll().size()).isEqualTo(3);
  }

  @Test
  void 이름으로_와인_조회() {
    String nmKor = "G7 멜롯";

    Pageable page = PageRequest.of(0, 3);
    Wine wine = wineRepository.findByNmKorIn(new String[] {nmKor}, page).toList().get(0);

    assertThat(wine.getNmKor()).isEqualTo("G7 멜롯");
    assertThat(wine.getCountry()).isEqualTo("칠레");
    assertThat(wine.getDegree()).isGreaterThan(10);
  }

}
