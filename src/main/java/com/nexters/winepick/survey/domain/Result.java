package com.nexters.winepick.survey.domain;

import com.nexters.winepick.constant.PersonalityType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Result {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "answer_type")
  @Enumerated(EnumType.STRING)
  private PersonalityType personalityType;

  private String subDesc;

  private String description;

  @Column(name = "keyword_1")
  private String keyword1;

  @Column(name = "keyword_2")
  private String keyword2;

  private String matchWine;

  private String feature;

  private Integer score;

}
