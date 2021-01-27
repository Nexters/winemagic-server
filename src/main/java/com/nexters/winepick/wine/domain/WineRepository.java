package com.nexters.winepick.wine.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Long> {
  Optional<Wine> findWineById(Integer wineId);
}
