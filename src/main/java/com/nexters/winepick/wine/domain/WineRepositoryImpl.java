package com.nexters.winepick.wine.domain;

import static com.nexters.winepick.wine.domain.QWine.wine;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
public class WineRepositoryImpl implements WineRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  @Override
  public Page<Wine> findByCondition(Pageable pageable, String wineName, String category,
      String food, String store, Integer start, Integer end) {

    QueryResults<Wine> wines = queryFactory
        .selectFrom(wine)
        .where((eqNmKor(wineName).or(eqNmEng(wineName)))
            , eqCategory(category)
            , likeFood(food)
            , likeStore(store)
            , degree(start, end))
        .fetchResults();

    return new PageImpl<>(wines.getResults(), pageable, wines.getTotal());

  }

  // 한국이름
  private BooleanExpression eqNmKor(String wineName) {
    if (StringUtils.isEmpty(wineName)) {
      return null;
    }
    return wine.nmKor.eq(wineName);
  }

  // 영어 이름
  private BooleanExpression eqNmEng(String wineName) {
    if (StringUtils.isEmpty(wineName)) {
      return null;
    }
    return wine.nmEng.eq(wineName);
  }

  // category
  private BooleanExpression eqCategory(String category) {
    if (StringUtils.isEmpty(category)) {
      return null;
    }
    return wine.category.eq(category);
  }

  // category
  private BooleanExpression likeFood(String food) {
    if (StringUtils.isEmpty(food)) {
      return null;
    }
    return wine.suitFood.contains(food);
  }

  // 가게
  private BooleanExpression likeStore(String store) {
    if (StringUtils.isEmpty(store)) {
      return null;
    }
    return wine.store.contains(store);
  }

  // 도수
  private BooleanExpression degree(Integer start, Integer end) {
    if (start == 0 || end == 0) {
      return null;
    }
    return wine.degree.between(start, end);
  }
}
