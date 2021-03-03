package com.nexters.winepick.like.domain;

import com.nexters.winepick.wine.domain.Wine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikesRepository extends JpaRepository<Likes, Long> {
  @Query("select w from Wine w join fetch w.likes l where l.user.id = :userId and l.useYn = 'Y'")
  List<Wine> findLikesByUserId(@Param("userId") Integer userId);

  @Query("select l from Likes l where l.user.id = :userId and l.useYn = 'Y'")
  List<Likes> findLikesByUserIdAndUseYn(@Param("userId") Integer userId);

  @Query("select l.wine.id from Likes l where l.user.id = :userId")
  List<Integer> findWineIdByUserId(@Param("userId") Integer userId);

  boolean existsLikesByWineIdAndUserId(Integer wineId, Integer userId);

  Optional<Likes> findLikesByUserIdAndWineId(Integer userId, Integer wineId);
}
