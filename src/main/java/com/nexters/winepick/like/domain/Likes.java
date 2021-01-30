package com.nexters.winepick.like.domain;

import com.nexters.winepick.base.BaseEntity;
import com.nexters.winepick.wine.domain.Wine;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Likes extends BaseEntity implements Serializable {

  public enum UseYn {
    Y, N
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer userId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "wine_id")
  private Wine wine;

  @Enumerated(EnumType.STRING)
  @Setter
  private UseYn useYn;

  @Builder
  public Likes(Integer userId, Wine wine, UseYn useYn) {
    this.userId = userId;
    this.wine = wine;
    this.useYn = useYn;
  }

  public static Likes of(Integer userId, Wine wine, UseYn useYn) {
    return new Likes(userId, wine, useYn);
  }

}
