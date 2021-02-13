package com.nexters.winepick.wine.service;

import com.nexters.winepick.wine.api.dto.KeywordResponse;
import com.nexters.winepick.wine.api.dto.WineResponse;
import com.nexters.winepick.wine.domain.KeywordRepository;
import com.nexters.winepick.wine.domain.Wine;
import com.nexters.winepick.wine.domain.WineRepository;
import com.nexters.winepick.wine.domain.WineRepositoryCustom;
import com.nexters.winepick.wine.exception.WineNotFoundException;
import io.micrometer.core.instrument.util.StringUtils;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WineService {

  private WineRepository wineRepository;
  private KeywordRepository keywordRepository;
  private WineRepositoryCustom wineRepositoryCustom;

  public Page<WineResponse> getWineList(Pageable pageable) {
    Page<Wine> winePage = wineRepository.findAll(pageable);
    return winePage.map(WineResponse::of);
  }

  public WineResponse getWine(Integer wineId) {
    Wine wine = wineRepository.findById(wineId)
        .orElseThrow(() -> new WineNotFoundException(wineId));
    return WineResponse.of(wine);
  }

  public Page<WineResponse> findWineByKeyword(List<String> keyword, Map<String, String> filter, Pageable pageable) {

    String[] food = null;
    if(!StringUtils.isEmpty(filter.get("food"))) {
      food = keywordRepository.findSearchWordByKeyword(filter.get("food")).split(",");
    }

    // 와인 찾고..
    Page<Wine> wines = wineRepositoryCustom
        .findByCondition(pageable, filter.get("wineName"), filter.get("category"),
            food, filter.get("store")
            , filter.get("start"), filter.get("end"));

    if (!"".equals(filter.get("keyword"))) {
      List<KeywordResponse> searchWordList = keywordRepository.findByKeywordIn(keyword).stream()
          .map(KeywordResponse::of).collect(Collectors.toList());
      List<WineResponse> filteredByKeyword = wines.stream().filter(t -> searchWordList.stream()
          .anyMatch(s -> t.getFeeling().contains(s.getSearchWord()))).map(WineResponse::of)
          .collect(Collectors.toList());

      int start = (int) pageable.getOffset();
      int end = (start + pageable.getPageSize()) > filteredByKeyword.size() ? filteredByKeyword.size() : (start + pageable.getPageSize());

      return new PageImpl<>(filteredByKeyword.subList(start, end), pageable, filteredByKeyword.size());
    }

    return wines.map(WineResponse::of);
  }

  public Page<WineResponse> getWineListByQuickKeyword(String keyword, Pageable pageable) {
    String[] names = keywordRepository.findSearchWordByKeyword(keyword).split(",");
    Page<Wine> winePage = wineRepository.findByNmKorIn(names, pageable);
    return winePage.map(WineResponse::of);
  }
}