package com.nexters.winepick.like.domain;

import com.nexters.winepick.wine.domain.Wine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikesRepository extends JpaRepository<Likes, Long> {
  @Query("select w from Wine w join fetch w.likes l where l.userId = :userId and l.useYn = 'Y'")
  List<Wine> getLikesWineList(@Param("userId") Integer userId);
}
