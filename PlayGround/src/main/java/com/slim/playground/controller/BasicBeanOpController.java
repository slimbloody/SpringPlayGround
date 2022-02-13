package com.slim.playground.controller;


import com.slim.playground.config.typeFilter.ScanConfig;
import com.slim.playground.service.PrintBeanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/basic_op")
public class BasicBeanOpController extends BaseController {
    // 测试filterType
    @PostMapping("/component_scans")
    public void componentScans() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanConfig.class);
        for (String name: context.getBeanDefinitionNames()) {
            log.info("{}", name);
        }
    }
}
