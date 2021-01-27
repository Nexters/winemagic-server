package com.nexters.winepick.wine.api;

import com.nexters.winepick.wine.api.dto.WineResponse;
import com.nexters.winepick.wine.service.WineService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wine")
@RequiredArgsConstructor
public class WineController {

  private final WineService wineService;

  @GetMapping
  public List<WineResponse> getWineList() {
    List<WineResponse> wines = wineService.getWineList();
    return wines;
  }

  @GetMapping("/{wineId}")
  public WineResponse getWine(@PathVariable Integer wineId) {
    WineResponse wine = wineService.getWine(wineId);
    return wine;
  }


}
