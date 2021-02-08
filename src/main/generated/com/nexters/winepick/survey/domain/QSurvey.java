package com.nexters.winepick.survey.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSurvey is a Querydsl query type for Survey
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSurvey extends EntityPathBase<Survey> {

    private static final long serialVersionUID = -972559796L;

    public static final QSurvey survey = new QSurvey("survey");

    public final com.nexters.winepick.base.QBaseEntity _super = new com.nexters.winepick.base.QBaseEntity(this);

    public final ListPath<Answer, QAnswer> answers = this.<Answer, QAnswer>createList("answers", Answer.class, QAnswer.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSurvey(String variable) {
        super(Survey.class, forVariable(variable));
    }

    public QSurvey(Path<? extends Survey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSurvey(PathMetadata metadata) {
        super(Survey.class, metadata);
    }

}

