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
    @PostMapping("/test")
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        log.info("=====start context=========");
        context.close();
    }
}
