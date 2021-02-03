package com.nexters.winepick.like.api.dto;

import com.nexters.winepick.like.domain.Likes;
import com.nexters.winepick.like.domain.Likes.UseYn;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.wine.domain.Wine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LikesResponse {

  private Integer id;

  private User user;

  private Wine wine;

  private UseYn useYn;

  public static LikesResponse of(Likes likes) {
    return new LikesResponse(likes.getId(), likes.getUser(), likes.getWine(), likes.getUseYn());
  }

}
