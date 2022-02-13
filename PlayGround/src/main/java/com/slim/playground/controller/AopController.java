package com.slim.playground.controller;

import com.slim.playground.config.aopPart.CalculateComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/aop")
public class AopController extends BaseController {
    @Autowired
    private CalculateComponent calculateComponent;

    /*
    beforeAround
    before
    addCalculate
    afterAround
    after
     */
    @PostMapping("/print_aop")
    public void printAop() {
        Integer integer1 = calculateComponent.addCalculate(1, 2);
        log.info("cal val: {}", integer1);

        Integer integer2 = calculateComponent.addCalculateThrowException(1, 2);
        log.info("cal val: {}", integer2);
    }
}
