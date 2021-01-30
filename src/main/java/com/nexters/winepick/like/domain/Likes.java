package com.nexters.winepick.like.domain;

import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.wine.domain.Wine;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Likes {

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
  private UseYn useYn;

}
