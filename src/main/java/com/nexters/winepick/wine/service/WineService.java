package com.nexters.winepick.wine.service;

import com.nexters.winepick.wine.api.dto.KeywordResponse;
import com.nexters.winepick.wine.api.dto.WineResponse;
import com.nexters.winepick.wine.domain.KeywordRepository;
import com.nexters.winepick.wine.domain.Wine;
import com.nexters.winepick.wine.domain.WineRepository;
import com.nexters.winepick.wine.domain.WineRepositoryCustom;
import com.nexters.winepick.wine.exception.WineNotFoundException;
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
    System.out.println(filter.size());
    System.out.println(filter.get("keyword"));
    System.out.println(keyword.size());
    System.out.println(filter.get("wineName"));
    System.out.println(filter.get("category")); // 와인 종류
    System.out.println(filter.get("food")); // 같이 먹는 음식
    System.out.println(filter.get("store")); // 판매 가게
    System.out.println(filter.get("start")); // 도수 시작
    System.out.println(filter.get("end")); // 도수 끝

    // 와인 찾고..
    Page<Wine> wines = wineRepositoryCustom
        .findByCondition(pageable, filter.get("wineName"), filter.get("category"),
            filter.get("food"), filter.get("store")
            , Integer.parseInt(filter.get("start")), Integer.parseInt(filter.get("end")));

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
}