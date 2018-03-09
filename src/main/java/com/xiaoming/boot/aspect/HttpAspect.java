package com.xiaoming.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

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
    public void doBefore(JoinPoint joinPoint){
        logger.info("===>doBefore");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //方法
        logger.info("args={}",joinPoint.getArgs());
    }

//    @After("execution(public * com.xiaoming.boot.contoller.GirlController.*(..))")
    @After("log()")
    public void doAfter(){
        logger.info("===>doAfter");
//        System.out.println("===>doAfter");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
