package com.slim.basic.spring.mvc.controller;

import com.slim.basic.spring.mvc.service.ConfigBeanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/print_bean")
public class ConfigBeanController {
    @Autowired
    public ConfigBeanService configBeanService;

    @PostMapping("/bean1")
    public void printBean1() {
        configBeanService.printBean1();
    }
}
