package com.nexters.winepick.wine.api.dto;

import com.nexters.winepick.wine.domain.Wine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WineResponse {

  private Integer id;

  private String nmKor;

  private String nmEng;

  private String country;

  private String store;

  private Long price;

  private String category;

  private String purpose;

  private Integer sweetness;

  private Integer acidity;

  private Integer body;

  private Integer tannin;

  private String feeling;

  private String suitWho;

  private String suitEvent;

  private String suitFood;

  private Integer likes;

  @Setter
  private boolean likeYn;

  public static WineResponse of(Wine wine) {
    return new WineResponse(wine.getId(), wine.getNmKor(), wine.getNmEng(), wine.getCountry(),
        wine.getStore(), wine.getPrice(), wine.getCategory(), wine.getPurpose(), wine.getSweetness(),
        wine.getAcidity(), wine.getBody(), wine.getTannin(), wine.getFeeling(), wine.getSuitWho(),
        wine.getSuitEvent(), wine.getSuitFood(), wine.getLikes().size(), wine.isLikeYn());
  }
}
