package com.zrt.score.handle;

import com.zrt.score.domain.ResultDomain;
import com.zrt.score.enums.ResultEnum;
import com.zrt.score.exception.ScoreException;
import com.zrt.score.utils.ScoreUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDomain handle(Exception e)
    {
        if(e instanceof ScoreException)
        {
            ScoreException scoreException=(ScoreException) e;
            return ScoreUtils.failed(scoreException.getMessage(),scoreException.getCode());
        }
        else
            {
                logger.info("【系统异常】{}",e);
                return ScoreUtils.failed(ResultEnum.UNKONW_ERROR.getMessage(),ResultEnum.UNKONW_ERROR.getCode());
            }
    }
}
