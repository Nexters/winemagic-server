package com.nexters.winepick.survey.domain;

import com.nexters.winepick.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Survey extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @Column(name = "answer_a")
    private String answerA;

    @Column(name = "answer_b")
    private String answerB;

}
