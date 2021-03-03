package com.nexters.winepick.wine.domain;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WineRepositoryCustom {

  List<Wine> findByCondition(Pageable pageable, String wineName, String category, String[] food, String store,
      String start, String end);

}
