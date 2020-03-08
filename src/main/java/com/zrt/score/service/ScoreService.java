package com.zrt.score.service;

import com.zrt.score.domain.ResultDomain;
import com.zrt.score.domain.ScoreDomain;
import com.zrt.score.enums.ResultEnum;
import com.zrt.score.exception.ScoreException;
import com.zrt.score.repository.ScoreRepository;
import com.zrt.score.utils.ScoreUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Properties;

@Service
public class ScoreService {
    private final static Logger logger= LoggerFactory.getLogger(ScoreService.class);
    @Autowired
    private ScoreRepository scoreRepository;
    //添加学生成绩
    @Transactional
    public ResultDomain<ScoreDomain> create_score(ScoreDomain scoreDomain, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ScoreUtils.failed(bindingResult.getFieldError().getDefaultMessage(),0);
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

    //条件查询  eg:输入id查询
    public ResultDomain<ScoreDomain> selectId(Integer id)
    {
        ScoreDomain scoreDomain=scoreRepository.findById(id).get();//不要findOne了改为findById(id).get()
        /*System.out.println(scoreRepository.findById(id).get());
        logger.info("数据是：{}",scoreDomain.getStuScore().toString());
        return null;*/
        if(scoreDomain.getStuScore()>100)
        {
            throw new ScoreException(ResultEnum.MORE);
        }
        else if(scoreDomain.getStuScore()<0)
        {
            throw new ScoreException(ResultEnum.LESS);
        }
        else if(scoreDomain.getStuScore()==null)
        {
            return ScoreUtils.failed("查找不到，请输入正确数据",4);
        }
        else return ScoreUtils.success(scoreDomain);
    }
}
