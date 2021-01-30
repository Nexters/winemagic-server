package com.nexters.winepick.like.api;

import com.nexters.winepick.like.service.LikesService;
import com.nexters.winepick.wine.api.dto.WineResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
