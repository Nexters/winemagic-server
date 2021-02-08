package com.nexters.winepick.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -204901074L;

    public static final QUser user = new QUser("user");

    public final com.nexters.winepick.base.QBaseEntity _super = new com.nexters.winepick.base.QBaseEntity(this);

    public final NumberPath<Integer> ageRange = createNumber("ageRange", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.nexters.winepick.constant.GenderType> gender = createEnum("gender", com.nexters.winepick.constant.GenderType.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ListPath<com.nexters.winepick.like.domain.Likes, com.nexters.winepick.like.domain.QLikes> likes = this.<com.nexters.winepick.like.domain.Likes, com.nexters.winepick.like.domain.QLikes>createList("likes", com.nexters.winepick.like.domain.Likes.class, com.nexters.winepick.like.domain.QLikes.class, PathInits.DIRECT2);

    public final StringPath nickname = createString("nickname");

    public final EnumPath<com.nexters.winepick.constant.PersonalityType> personalityType = createEnum("personalityType", com.nexters.winepick.constant.PersonalityType.class);

    public final ListPath<Token, QToken> tokens = this.<Token, QToken>createList("tokens", Token.class, QToken.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

