package com.zrt.score.controller;

import com.zrt.score.domain.ScoreDomain;
import com.zrt.score.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;
    //添加学生成绩
    @GetMapping(value="/create/score")
    public ScoreDomain create_score(ScoreDomain scoreDomain)
    {
        ScoreDomain s=new ScoreDomain();
        s.setStuNo(scoreDomain.getStuNo());
        s.setStuName(scoreDomain.getStuName());
        s.setStuClass(scoreDomain.getStuClass());
        s.setStuType(scoreDomain.getStuType());
        s.setStuScore(scoreDomain.getStuScore());
        scoreRepository.save(s);
        return s;
    }
}
