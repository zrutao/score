package com.zrt.score.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Aspect
@Component
public class ScoreAspect {
    private final static Logger logger= LoggerFactory.getLogger(ScoreAspect.class);
    @Pointcut("execution(public * com.zrt.score.controller.ScoreController.*(..))")
    public void log()
    { }
    @Before("log()")
    public void loginAspect()
    {
        logger.info("调用了before。。。。。。");
    }
    @After("log()")
    public void doAfter()
    {
        logger.info("调用了after。。。。。。");
    }
}
