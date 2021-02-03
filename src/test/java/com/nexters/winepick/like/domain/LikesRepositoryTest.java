package com.nexters.winepick.like.domain;

import com.nexters.winepick.wine.domain.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class LikesRepositoryTest {

  @Autowired
  LikesRepository likesRepository;

  @Autowired
  WineRepository wineRepository;

}
