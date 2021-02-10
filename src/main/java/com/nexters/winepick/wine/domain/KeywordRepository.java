package com.nexters.winepick.wine.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Integer> {

  List<Keyword> findByKeywordIn(List<String> keyword);
}
