package com.zrt.score.repository;

import com.zrt.score.domain.ScoreDomain;
import org.springframework.data.jpa.repository.JpaRepository;

//也就是dao
public interface ScoreRepository extends JpaRepository<ScoreDomain,Integer> {//写实体类名名称，和主键的类型
}
