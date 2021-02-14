package com.nexters.winepick.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexters.winepick.base.BaseEntity;
import com.nexters.winepick.constant.GenderType;
import com.nexters.winepick.constant.PersonalityType;
import com.nexters.winepick.like.domain.Likes;
import java.util.List;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@NoArgsConstructor
@Data
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String email;

  private String nickname;

  private int ageRange;

  @Enumerated(EnumType.STRING)
  @Column(name = "gender")
  private GenderType gender;

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
  public User(String email, int ageRange, GenderType gender) {
    Assert.hasText(email, "bankName must not be empty");
    Assert.hasText(Integer.toString(ageRange), "accountNumber must not be empty");
    Assert.hasText(gender.toString(), "accountHolder must not be empty");
    this.email = email;
    this.ageRange = ageRange;
    this.gender = gender;
  }
}
