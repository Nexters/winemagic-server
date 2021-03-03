package com.nexters.winepick.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexters.winepick.base.BaseEntity;
import com.nexters.winepick.constant.PersonalityType;
import com.nexters.winepick.like.domain.Likes;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private BigInteger userId;

  @Enumerated(EnumType.STRING)
  @Column(name = "personality")
  private PersonalityType personalityType;

  @Column(name = "access_token", unique = true)
  private String accessToken;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private List<Likes> likes;

  @Builder
  public User(String accessToken, BigInteger userId, PersonalityType personalityType, List<Likes> likes) {
    this.accessToken = accessToken;
    this.userId = userId;
    this.personalityType = personalityType;
    this.likes = likes;
  }
}
