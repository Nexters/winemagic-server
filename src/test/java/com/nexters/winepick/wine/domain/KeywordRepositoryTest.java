package com.nexters.winepick.wine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.nexters.winepick.config.TestConfig;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(TestConfig.class)
public class KeywordRepositoryTest {

  @Autowired
  private KeywordRepository keywordRepository;

  @Test
  void 키워드_리스트_조회() {
    List<String> inputKeyword = new ArrayList<>();
    inputKeyword.add("달콤한");

    List<Keyword> keywordList = keywordRepository.findByKeywordIn(inputKeyword);
    assertThat(keywordList.size()).isEqualTo(6);
  }

  @Test
  void 키워드_검색어_조회() {
    String searchWord = keywordRepository.findSearchWordByKeyword("집들이 선물");
    assertThat(searchWord).contains("G7 샤도네이");
  }

}
