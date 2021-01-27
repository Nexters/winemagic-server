package com.nexters.winepick.wine.api.dto;

import com.nexters.winepick.wine.domain.Wine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WineResponse {

  private Integer id;

  private String nmKor;

  private String nmEng;

  private String country;

  private Long price;

  private String category;

  private Integer sweetness;

  private Integer acidity;

  private Integer body;

  private Integer tannin;

  public static WineResponse of(Wine wine) {
    return new WineResponse(wine.getId(), wine.getNmKor(), wine.getNmEng(), wine.getCountry(),
        wine.getPrice(), wine.getCategory(), wine.getSweetness(), wine.getAcidity(), wine.getBody(),
        wine.getTannin());
  }

}
