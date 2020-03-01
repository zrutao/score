package com.zrt.score.controller;

import com.zrt.score.domain.ResultDomain;
import com.zrt.score.domain.ScoreDomain;
import com.zrt.score.enums.ResultEnum;
import com.zrt.score.repository.ScoreRepository;
import com.zrt.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    //添加学生成绩
    @GetMapping(value="/create/score")
    public ResultDomain<ScoreDomain> create_score(@Valid ScoreDomain scoreDomain, BindingResult bindingResult)
    {
       return scoreService.create_score(scoreDomain,bindingResult);
    }

    //查询学生列表信息
    @PostMapping(value="/update/score")
    public List<ScoreDomain> update_score()
    {
        return scoreService.update_score();
    }

    //条件查询

}
