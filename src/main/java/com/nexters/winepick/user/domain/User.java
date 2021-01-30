package com.nexters.winepick.user.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

  public enum Gender {
    FEMALE, MALE
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;

  private int ageRange;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Builder
  public User(String email, int ageRange, Gender gender) {
    this.email = email;
    this.ageRange = ageRange;
    this.gender = gender;
  }


}