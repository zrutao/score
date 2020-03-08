package com.zrt.score.utils;

import com.zrt.score.domain.ResultDomain;
import com.zrt.score.domain.ScoreDomain;
import com.zrt.score.enums.ResultEnum;
import org.springframework.validation.BindingResult;

//成功和失败
public class ScoreUtils {

    public static ResultDomain<ScoreDomain> success(ScoreDomain scoreDomain)
    {

        ResultDomain resultDomain=new ResultDomain();//最外层
        resultDomain.setCode(ResultEnum.SUCCESS.getCode());
        resultDomain.setMessage(ResultEnum.SUCCESS.getMessage());
        resultDomain.setData(scoreDomain);
        return resultDomain;
    }
    public static ResultDomain<ScoreDomain> failed(String message,Integer code)
    {
        ResultDomain resultDomain=new ResultDomain();
        resultDomain.setCode(code);
        resultDomain.setMessage(message);
        return resultDomain;
    }

}
