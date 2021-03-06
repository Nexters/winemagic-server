package com.nexters.winepick.wine.api;

import com.nexters.winepick.base.BaseResponse;
import com.nexters.winepick.wine.api.dto.WineResponse;
import com.nexters.winepick.wine.service.WineService;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wine")
@RequiredArgsConstructor
public class WineController {

  private final WineService wineService;

  @GetMapping
  public BaseResponse<Page<WineResponse>> page(HttpServletRequest req, Pageable pageable) {
    String accessToken = req.getHeader(HttpHeaders.AUTHORIZATION);
    Page<WineResponse> wines = wineService.getWineList(accessToken, pageable);
    return new BaseResponse<>(200, "0", wines);
  }

  @GetMapping("/{wineId}")
  public BaseResponse<WineResponse> getWine(HttpServletRequest req, @PathVariable Integer wineId) {
    String accessToken = req.getHeader(HttpHeaders.AUTHORIZATION);
    WineResponse wine = wineService.getWine(accessToken, wineId);
    return new BaseResponse<>(200, "0", wine);
  }

  @GetMapping("/filter")
  public BaseResponse<Page<WineResponse>> search(HttpServletRequest req, @RequestParam List<String> keyword, @RequestParam HashMap<String, String> filter, Pageable pageable) {
    String accessToken = req.getHeader(HttpHeaders.AUTHORIZATION);
    Page<WineResponse> wines = wineService.findWineByKeyword(accessToken, keyword, filter, pageable);
    return new BaseResponse<>(200, "0", wines);
  }

  @GetMapping("/keyword")
  public BaseResponse<Page<WineResponse>> quickSearch(HttpServletRequest req, @RequestParam String keyword,Pageable pageable) {
    String accessToken = req.getHeader(HttpHeaders.AUTHORIZATION);
    Page<WineResponse> wines = wineService.getWineListByQuickKeyword(accessToken, keyword, pageable);
    return new BaseResponse<>(200, "0", wines);
  }

}
