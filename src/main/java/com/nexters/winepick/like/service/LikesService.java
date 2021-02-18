package com.nexters.winepick.like.service;

import com.nexters.winepick.like.api.dto.LikesRequest;
import com.nexters.winepick.like.domain.Likes;
import com.nexters.winepick.like.domain.Likes.UseYn;
import com.nexters.winepick.like.domain.LikesRepository;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.repository.UserRepository;
import com.nexters.winepick.user.exception.UserNotFoundException;
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

  private final LikesRepository likesRepository;
  private final WineRepository wineRepository;
  private final UserRepository userRepository;

  public List<WineResponse> getLikesWineList(Integer userId) {
    return this.likesRepository.findLikesByUserId(userId)
        .stream().map(WineResponse::of).collect(Collectors.toList());
  }

  public void addLike(LikesRequest request) {
    // 이미 이전에 좋아요 했던 경우
    this.likesRepository.findLikesByUserIdAndWineId(request.getUserId(), request.getWineId())
        .ifPresent(likes -> {
          likes.setUseYn(UseYn.Y);
          this.likesRepository.save(likes);
        });

    // 처음 좋아요 하는 경우
    if (!this.likesRepository.existsLikesByUserIdAndWineId(request.getUserId(), request.getWineId())) {
      Wine wine = this.wineRepository.findById(request.getWineId())
          .orElseThrow(() -> new WineNotFoundException(request.getWineId()));
      User user = this.userRepository.findById(request.getUserId())
          .orElseThrow(() -> new UserNotFoundException(request.getUserId()));
      this.likesRepository.save(Likes.of(user, wine, UseYn.Y));
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
