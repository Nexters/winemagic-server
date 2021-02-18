package com.nexters.winepick.wine.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KeywordRepository extends JpaRepository<Keyword, Integer> {

  List<Keyword> findByKeywordIn(List<String> keyword);

  @Query("select k.searchWord from Keyword k where k.keyword = :keyword")
  String findSearchWordByKeyword(@Param("keyword") String keyword);

}
