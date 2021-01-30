package com.nexters.winepick.like.service;

import com.nexters.winepick.like.domain.LikesRepository;
import com.nexters.winepick.wine.api.dto.WineResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LikesService {

  private LikesRepository likesRepository;

  public List<WineResponse> getLikesWineList(Integer userId) {
    return likesRepository.getLikesWineList(userId)
        .stream().map(WineResponse::of).collect(Collectors.toList());
  }

}
