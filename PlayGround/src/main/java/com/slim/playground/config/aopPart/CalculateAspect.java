package com.slim.playground.config.aopPart;

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

@Aspect
@Slf4j
public class CalculateAspect {
    /**
     * core: JointPoint 如果出现在参数列表, 一定要出现在参数列表的最前面
     * steps:
     * 1. 将业务逻辑组件和切面类都加入到容器中,告诉Spring哪个是切面类(@Aspect)
     * 2. 在切面类上的每一个通知方法上标注通知注解, 告诉Spring合适何地运行(切入点表达式)
     * 3. 开启基于注解的aop模式, @EnableAspectJAutoProxy
     */
    @Pointcut("execution(public Integer com.slim.playground.config.aopPart.CalculateComponent.*(..))")
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
    // todo: AfterThrowing能否catch住之后的exception
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
