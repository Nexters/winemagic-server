package com.nexters.winepick.wine.service;

import com.nexters.winepick.like.domain.LikesRepository;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.exception.UserInvalidAccessTokenException;
import com.nexters.winepick.user.repository.UserRepository;
import com.nexters.winepick.wine.api.dto.KeywordResponse;
import com.nexters.winepick.wine.api.dto.WineResponse;
import com.nexters.winepick.wine.domain.KeywordRepository;
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
import org.springframework.util.ObjectUtils;

@AllArgsConstructor
@Service
public class WineService {

  private WineRepository wineRepository;
  private KeywordRepository keywordRepository;
  private WineRepositoryCustom wineRepositoryCustom;
  private UserRepository userRepository;
  private LikesRepository likesRepository;

  public Page<WineResponse> getWineList(String accessToken, Pageable pageable) {
    List<WineResponse> wines = wineRepository.findAll().stream().map(WineResponse::of).collect(
        Collectors.toList());
    return verifyUserLikedYn(accessToken, wines, pageable);
  }

  public WineResponse getWine(String accessToken, Integer wineId) {
    WineResponse wine = WineResponse.of(wineRepository.findById(wineId)
        .orElseThrow(() -> new WineNotFoundException(wineId)));

    if (!ObjectUtils.isEmpty(accessToken)) {
      User user = userRepository.findUserByAccessToken(accessToken)
          .orElseThrow(() -> new UserInvalidAccessTokenException(accessToken));

      if (likesRepository.existsLikesByWineIdAndUserId(wineId, user.getId())) {
        wine.setLikeYn(true);
      }
    }
    return wine;
  }

  public Page<WineResponse> findWineByKeyword(String accessToken, List<String> keyword, Map<String, String> filter, Pageable pageable) {

    String[] food = null;
    if (!ObjectUtils.isEmpty(filter.get("food"))) {
      food = keywordRepository.findSearchWordByKeyword(filter.get("food")).split(",");
    }

    List<WineResponse> wines = wineRepositoryCustom
        .findByCondition(pageable, filter.get("wineName"), filter.get("category"),
            food, filter.get("store"), filter.get("start"), filter.get("end")).stream().map(WineResponse::of).collect(
            Collectors.toList());

    if (!"".equals(filter.get("keyword"))) {
      List<KeywordResponse> searchWordList = keywordRepository.findByKeywordIn(keyword).stream()
          .map(KeywordResponse::of).collect(Collectors.toList());
      List<WineResponse> filteredByKeyword = wines.stream().filter(t -> searchWordList.stream()
          .anyMatch(s -> t.getFeeling().contains(s.getSearchWord()))).collect(Collectors.toList());

      return verifyUserLikedYn(accessToken, filteredByKeyword, pageable);
    }
    return verifyUserLikedYn(accessToken, wines, pageable);
  }

  public Page<WineResponse> getWineListByQuickKeyword(String accessToken, String keyword, Pageable pageable) {
    String[] names = keywordRepository.findSearchWordByKeyword(keyword).split(",");
    List<WineResponse> wines = wineRepository.findByNmKorIn(names).stream().map(WineResponse::of).collect(
        Collectors.toList());
    return verifyUserLikedYn(accessToken, wines, pageable);
  }


  public Page<WineResponse> verifyUserLikedYn(String accessToken, List<WineResponse> wineResponseList, Pageable pageable) {
    if (!ObjectUtils.isEmpty(accessToken)) {
      User user = userRepository.findUserByAccessToken(accessToken)
          .orElseThrow(() -> new UserInvalidAccessTokenException(accessToken));
      List<Integer> likes = likesRepository.findWineIdByUserId(user.getId());
      wineResponseList.forEach(w -> {
        if (likes.contains(w.getId())) {
          w.setLikeYn(true);
        }
      });
    }

    int start = (int) pageable.getOffset();;
    int end = 0;
    end = (start + pageable.getPageSize()) > wineResponseList.size() ? wineResponseList.size() : (start + pageable.getPageSize());

    return new PageImpl<>(wineResponseList.subList(start, end), pageable, wineResponseList.size());
  }
}