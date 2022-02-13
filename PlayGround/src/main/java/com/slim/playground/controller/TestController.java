package com.slim.playground.controller;

import com.slim.playground.service.PrintBeanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test_controller")
public class TestController extends BaseController {
    @Autowired
    private PrintBeanService service;

    @PostMapping("/get_env")
    public void getEnv() {
        service.getEnv();
    }

    @PostMapping("/get_autowired_bean")
    public void getAutowiredBean() {
        service.getAutowiredBean();
    }

    // @PostMapping("/get_autowired_bean_diff")
    // public void getAutowiredBeanDiff() {
    //     service.getAutowiredBeanDiff();
    // }
}
