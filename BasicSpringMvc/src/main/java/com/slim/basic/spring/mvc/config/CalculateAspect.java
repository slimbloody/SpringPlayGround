package com.slim.basic.spring.mvc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class CalculateAspect {
    @Pointcut("execution(public Integer com.slim.basic.spring.mvc.beans.CalculateComponent.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        log.info("before");
    }

    // 正常异常结束都会被调用
    @After("pointCut()")
    public void after() {
        log.info("after");
    }


    @AfterReturning(value = "pointCut()", returning = "res")
    public void afterReturning(Object res) {
        log.info("afterReturning: {}", res);
    }

    // todo: 为什么切面方法可以变参被接收的
    // todo: AfterThrowing能否catch住exception
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.info("joinPoint: {}; afterThrowing: ", joinPoint.getSignature(), exception);
    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("beforeAround");
        Object result = proceedingJoinPoint.proceed();
        log.info("afterAround");
        return result;
    }
}
