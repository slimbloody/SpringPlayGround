package com.slim.playground.controller.aop;

import com.slim.playground.config.aopPart.AopConfig;
import com.slim.playground.config.aopPart.CalculateComponent;
import com.slim.playground.controller.ioc.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/aop")
public class AopController extends BaseController {
    /*
    beforeAround
    before
    addCalculate
    afterAround
    after
     */
    @PostMapping("/config")
    public void config() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        CalculateComponent component = context.getBean(CalculateComponent.class);

        Integer integer1 = component.addCalculate(1, 2);
        log.info("cal val: {}", integer1);

        Integer integer2 = component.addCalculateThrowException(1, 2);
        log.info("cal val: {}", integer2);

        context.close();
    }
}
