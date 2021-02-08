package com.nexters.winepick.like.api.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LikesRequest {

  @NotNull
  private int userId;

  @NotNull
  private int wineId;

}
