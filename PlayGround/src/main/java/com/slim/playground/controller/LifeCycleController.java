package com.slim.playground.controller;


import com.slim.playground.config.lifeCycle.LifeCycleConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/life_cycle")
public class LifeCycleController {
    /*
// 初始化所有的单实例对象之后
// Instantiate all remaining (non-lazy-init) singletons.
finishBeanFactoryInitialization(beanFactory);

org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization
org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsAfterInitialization
只要有一个 beanPostProcessor 里面的方法返回null, 那么整个链路就终止了, 返回null

todo: populateBean的时候也会执行一些beanPostProcessor
     */

    @PostMapping("/test")
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        log.info("=====start context=========");
        context.close();
    }

    /*
    spring底层对 beanPostProcessor 的使用
    ApplicationContextAwareProcessor: 往组件里面注入ioc容器
    implement ApplicationContextAware
    org.springframework.context.support.ApplicationContextAwareProcessor#postProcessBeforeInitialization
     */
}
