package com.nexters.winepick.wine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexters.winepick.like.domain.Likes;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
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

  private String ingredient;

  private String category;

  private String purpose;

  private String store;

  private double degree;

  private String suitTemper;

  private Integer sweetness;

  private Integer acidity;

  private Integer body;

  private Integer tannin;

  private String feeling;

  private String suitWho;

  private String suitEvent;

  private String suitFood;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "wine_id")
  @JsonIgnore
  private List<Likes> likes;

  @Transient
  private boolean likeYn;

  @Builder
  public Wine(String nmKor, String nmEng, String country, Long price, String ingredient,
      String category, String purpose, double degree, String suitTemper, Integer sweetness,
      Integer acidity, Integer body, Integer tannin, String feeling, String suitWho,
      String suitEvent, String suitFood) {
    this.nmKor = nmKor;
    this.nmEng = nmEng;
    this.country = country;
    this.price = price;
    this.ingredient = ingredient;
    this.category = category;
    this.purpose = purpose;
    this.degree = degree;
    this.suitTemper = suitTemper;
    this.sweetness = sweetness;
    this.acidity = acidity;
    this.body = body;
    this.tannin = tannin;
    this.feeling = feeling;
    this.suitWho = suitWho;
    this.suitEvent = suitEvent;
    this.suitFood = suitFood;
  }

}
