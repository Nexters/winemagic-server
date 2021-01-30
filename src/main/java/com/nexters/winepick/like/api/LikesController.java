package com.nexters.winepick.like.api;

import com.nexters.winepick.like.service.LikesService;
import com.nexters.winepick.wine.api.dto.WineResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikesController {

  private final LikesService likesService;

  @GetMapping("/{userId}")
  public List<WineResponse> getLikesWineList(@PathVariable Integer userId) {
    return likesService.getLikesWineList(userId);
  }

  @PostMapping("/{userId}/{wineId}")
  public void addLike(@PathVariable Integer userId, @PathVariable Integer wineId) {
    likesService.addLike(userId, wineId);
  }

  @PutMapping("/{userId}/{wineId}")
  public void deleteLike(@PathVariable Integer userId, @PathVariable Integer wineId) {
    likesService.deleteLike(userId, wineId);
  }

}
