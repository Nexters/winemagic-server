package com.nexters.winepick.like.service;

import com.nexters.winepick.like.domain.Likes;
import com.nexters.winepick.like.domain.Likes.UseYn;
import com.nexters.winepick.like.domain.LikesRepository;
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
public class LikesService {

  private LikesRepository likesRepository;
  private WineRepository wineRepository;

  public List<WineResponse> getLikesWineList(Integer userId) {
    return likesRepository.getLikesWineList(userId)
        .stream().map(WineResponse::of).collect(Collectors.toList());
  }

  public void addLike(Integer userId, Integer wineId) {
    // 이미 이전에 좋아요 했던 경우
    likesRepository.findLikesByUserIdAndWineId(userId, wineId)
        .ifPresent(likes -> {
          likes.setUseYn(UseYn.Y);
          likesRepository.save(likes);
        });

    // 처음 좋아요 하는 경우
    if (!likesRepository.existsLikesByUserIdAndWineId(userId, wineId)) {
      Wine wine = wineRepository.findWineById(wineId)
          .orElseThrow(() -> new WineNotFoundException(wineId));
      likesRepository.save(Likes.of(userId, wine, UseYn.Y));
    }
  }

  public void deleteLike(Integer userId, Integer wineId) {
    likesRepository.findLikesByUserIdAndWineId(userId, wineId)
        .ifPresent(likes -> {
          likes.setUseYn(UseYn.N);
          likesRepository.save(likes);
        });
  }

}
