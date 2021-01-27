package com.nexters.winepick.wine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Wine {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nmKor;

  private String nmEng;

  private String country;

  private Long price;

  private String kind;

  private String category;

  private String usage;

  private double degree;

  private String drinkingTemper;

  private Integer sweetness;

  private Integer acidity;

  private Integer body;

  private Integer tannin;

  private String suitDish;

  @Builder
  public Wine(String nmKor, String nmEng, String country, Long price, String kind,
      String category, String usage, double degree, String drinkingTemper, Integer sweetness,
      Integer acidity, Integer body, Integer tannin, String suitDish) {
    this.nmKor = nmKor;
    this.nmEng = nmEng;
    this.country = country;
    this.price = price;
    this.kind = kind;
    this.category = category;
    this.usage = usage;
    this.degree = degree;
    this.drinkingTemper = drinkingTemper;
    this.sweetness = sweetness;
    this.acidity = acidity;
    this.body = body;
    this.tannin = tannin;
    this.suitDish = suitDish;
  }

}
