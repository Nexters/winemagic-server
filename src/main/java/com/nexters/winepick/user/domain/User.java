package com.nexters.winepick.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexters.winepick.base.BaseEntity;
import com.nexters.winepick.base.PersonalityType;
import com.nexters.winepick.like.domain.Likes;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

  public enum Gender {
    FEMALE, MALE
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String email;

  private String nickname;

  private int ageRange;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Enumerated(EnumType.STRING)
  @Column(name = "personality")
  private PersonalityType personalityType;

  private String accessToken;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private List<Likes> likes;

  @Builder
  public User(String email, int ageRange, Gender gender) {
    this.email = email;
    this.ageRange = ageRange;
    this.gender = gender;
  }


}
