package com.zrt.score.service;

import com.zrt.score.domain.ResultDomain;
import com.zrt.score.domain.ScoreDomain;
import com.zrt.score.enums.ResultEnum;
import com.zrt.score.repository.ScoreRepository;
import com.zrt.score.utils.ScoreUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Properties;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    //添加学生成绩
    public ResultDomain<ScoreDomain> create_score(ScoreDomain scoreDomain, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ScoreUtils.failed(bindingResult);
        }
        ScoreDomain s=new ScoreDomain();//内层
        s.setStuNo(scoreDomain.getStuNo());
        s.setStuName(scoreDomain.getStuName());
        s.setStuClass(scoreDomain.getStuClass());
        s.setStuType(scoreDomain.getStuType());
        s.setStuScore(scoreDomain.getStuScore());
        scoreRepository.save(s);
        return ScoreUtils.success(s);
    }

    //查询学生列表信息
    public List<ScoreDomain> update_score()
    {
        return scoreRepository.findAll();
    }
}
