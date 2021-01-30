package com.nexters.winepick.wine.service;

import com.nexters.winepick.wine.api.dto.WineResponse;
import com.nexters.winepick.wine.domain.Wine;
import com.nexters.winepick.wine.domain.WineRepository;
import com.nexters.winepick.wine.exception.WineNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WineService {

  private WineRepository wineRepository;

  public List<WineResponse> getWineList() {
    return wineRepository.findAll().stream()
        .map(WineResponse::of).collect(Collectors.toList());
  }

  public WineResponse getWine(Integer wineId) {
    Wine wine = wineRepository.findById(wineId)
        .orElseThrow(() -> new WineNotFoundException(wineId));
    return WineResponse.of(wine);
  }
}
