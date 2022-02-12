package com.slim.playground.controller;

import com.slim.playground.service.PrintBeanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/TestController")
public class TestController {
    @Autowired
    private PrintBeanService service;

    @PostMapping("/bean1")
    public void printBean1() {
        service.printBean1();
    }

    @PostMapping("/component_scans")
    public void componentScans() {
        service.componentScans();
    }

    @PostMapping("/print")
    public void getBean() {
        service.print();
    }

    @PostMapping("/check_scope")
    public void checkScope() {
        service.checkScope();
    }

    @PostMapping("/get_lazy_false")
    public void getLazy() {
        service.getLazyFalse();
    }

    @PostMapping("/get_lazy_true")
    public void getTrue() {
        service.getLazyTrue();
    }

    @PostMapping("/get_import")
    public void getImport() {
        service.getImport();
    }

    @PostMapping("/get_factory_bean")
    public void getFactoryBean() {
        service.getFactoryBean();
    }

    @PostMapping("/get_env")
    public void getEnv() {
        service.getEnv();
    }

    @PostMapping("/get_autowired_bean")
    public void getAutowiredBean() {
        service.getAutowiredBean();
    }

    @PostMapping("/get_autowired_bean_diff")
    public void getAutowiredBeanDiff() {
        service.getAutowiredBeanDiff();
    }

/*
beforeAround
before
addCalculate
afterAround
after
 */
    @PostMapping("/print_aop")
    public void printAop() {
        service.printAop();
    }
}
