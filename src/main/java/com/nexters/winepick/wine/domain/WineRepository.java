package com.nexters.winepick.wine.domain;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Integer> {
  @EntityGraph(attributePaths = "likes")
  List<Wine> findAll();

  List<Wine> findByNmKorIn(String[] nmKor);
}
