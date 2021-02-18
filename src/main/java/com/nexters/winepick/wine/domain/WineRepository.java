package com.nexters.winepick.wine.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Integer> {
  Page<Wine> findAll(Pageable pageable);

  Page<Wine> findByNmKorIn(String[] nmKor, Pageable pageable);
}
