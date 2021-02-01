package com.nexters.winepick.wine.api;

import com.nexters.winepick.base.BaseResponse;
import com.nexters.winepick.wine.api.dto.WineResponse;
import com.nexters.winepick.wine.service.WineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wine")
@RequiredArgsConstructor
public class WineController {

  private final WineService wineService;

  @GetMapping
  public BaseResponse<Page<WineResponse>> page(Pageable pageable) {
    Page<WineResponse> wines = wineService.getWineList(pageable);
    return new BaseResponse<>(200, "0", wines);
  }

  @GetMapping("/{wineId}")
  public BaseResponse<WineResponse> getWine(@PathVariable Integer wineId) {
    WineResponse wine = wineService.getWine(wineId);
    return new BaseResponse<>(200, "0", wine);
  }

}
