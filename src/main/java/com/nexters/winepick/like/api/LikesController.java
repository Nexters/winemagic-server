package com.nexters.winepick.like.api;

import com.nexters.winepick.base.BaseDataJsonResponse;
import com.nexters.winepick.base.BaseMsgJsonResponse;
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
  public BaseDataJsonResponse<List<WineResponse>> getLikesWineList(@PathVariable Integer userId) {
    List<WineResponse> likes = likesService.getLikesWineList(userId);
    return new BaseDataJsonResponse<>(200, "0", likes);
  }

  @PostMapping("/{userId}/{wineId}")
  public BaseMsgJsonResponse addLike(@PathVariable Integer userId, @PathVariable Integer wineId) {
    likesService.addLike(userId, wineId);
    return new BaseMsgJsonResponse(200, "0");
  }

  @PutMapping("/{userId}/{wineId}")
  public BaseMsgJsonResponse deleteLike(@PathVariable Integer userId, @PathVariable Integer wineId) {
    likesService.deleteLike(userId, wineId);
    return new BaseMsgJsonResponse(200, "0");
  }

}
