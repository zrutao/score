package com.zrt.score.service;

import com.zrt.score.domain.ResultDomain;
import com.zrt.score.domain.ScoreDomain;
import com.zrt.score.repository.ScoreRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ScoreServiceTest {

    @Autowired
    private ScoreService scoreService;
    @Test
    void selectId() {
        ResultDomain<ScoreDomain> scoreDomainResultDomain= scoreService.selectId(69);
        Assert.assertEquals(new Integer(100),scoreDomainResultDomain.getData().getStuScore());//是否一致
    }

    @Test
    void update_score() {
        List<ScoreDomain> scoreDomain= scoreService.update_score();
        Assert.assertNotEquals(0,scoreDomain.size());//返回数目是否为0
    }
}