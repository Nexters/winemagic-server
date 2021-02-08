package com.nexters.winepick.wine.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWine is a Querydsl query type for Wine
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWine extends EntityPathBase<Wine> {

    private static final long serialVersionUID = 142643370L;

    public static final QWine wine = new QWine("wine");

    public final NumberPath<Integer> acidity = createNumber("acidity", Integer.class);

    public final NumberPath<Integer> body = createNumber("body", Integer.class);

    public final StringPath category = createString("category");

    public final StringPath country = createString("country");

    public final NumberPath<Double> degree = createNumber("degree", Double.class);

    public final StringPath feeling = createString("feeling");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath ingredient = createString("ingredient");

    public final ListPath<com.nexters.winepick.like.domain.Likes, com.nexters.winepick.like.domain.QLikes> likes = this.<com.nexters.winepick.like.domain.Likes, com.nexters.winepick.like.domain.QLikes>createList("likes", com.nexters.winepick.like.domain.Likes.class, com.nexters.winepick.like.domain.QLikes.class, PathInits.DIRECT2);

    public final StringPath nmEng = createString("nmEng");

    public final StringPath nmKor = createString("nmKor");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final StringPath purpose = createString("purpose");

    public final StringPath store = createString("store");

    public final StringPath suitEvent = createString("suitEvent");

    public final StringPath suitFood = createString("suitFood");

    public final StringPath suitTemper = createString("suitTemper");

    public final StringPath suitWho = createString("suitWho");

    public final NumberPath<Integer> sweetness = createNumber("sweetness", Integer.class);

    public final NumberPath<Integer> tannin = createNumber("tannin", Integer.class);

    public QWine(String variable) {
        super(Wine.class, forVariable(variable));
    }

    public QWine(Path<? extends Wine> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWine(PathMetadata metadata) {
        super(Wine.class, metadata);
    }

}

