package com.nexters.winepick.wine.service;

import com.nexters.winepick.wine.api.dto.WineResponse;
import com.nexters.winepick.wine.domain.Wine;
import com.nexters.winepick.wine.domain.WineRepository;
import com.nexters.winepick.wine.exception.WineNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WineService {

  private final WineRepository wineRepository;

  public Page<WineResponse> getWineList(Pageable pageable) {
    Page<Wine> winePage = this.wineRepository.findAll(pageable);
    return winePage.map(WineResponse::of);
  }

  public WineResponse getWine(Integer wineId) {
    Wine wine = this.wineRepository.findById(wineId)
        .orElseThrow(() -> new WineNotFoundException(wineId));
    return WineResponse.of(wine);
  }
}
