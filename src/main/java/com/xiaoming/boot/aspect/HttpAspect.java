package com.xiaoming.boot.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * AOP切面
 */
@Aspect
@Component
public class HttpAspect {

    //日志org.slf4j
    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.xiaoming.boot.contoller.GirlController.*(..))")
    public void log(){
        System.out.println("===>pointcut");
    }

    //拦截GirlController所有方法  @Before执行之前进行拦截
//    @Before("execution(public * com.xiaoming.boot.contoller.GirlController.*(..))")
    @Before("log()")
    public void doBefore(){
        logger.info("===>doBefore");
//        System.out.println("===>doBefore");
    }

//    @After("execution(public * com.xiaoming.boot.contoller.GirlController.*(..))")
    @After("log()")
    public void doAfter(){
        logger.info("===>doAfter");
//        System.out.println("===>doAfter");
    }
}
