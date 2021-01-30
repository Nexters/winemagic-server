package com.nexters.winepick.survey.domain;

import com.nexters.winepick.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Answer extends BaseEntity {

    public enum AnswerType {
        // TODO => We might update answer types' information.
        A, B, C, D, E, F
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @Enumerated(EnumType.STRING)
    private AnswerType answerType;
}
