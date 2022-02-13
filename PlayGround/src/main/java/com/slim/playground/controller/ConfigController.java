package com.slim.playground.controller;


import com.slim.playground.config.loadConfig.TestBeanValueConfig;
import com.slim.playground.config.typeFilter.ImportAnnotationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/config")
public class ConfigController extends BaseController {
    @PostMapping("/get_import")
    public void getImport() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportAnnotationConfig.class);
        for (String name: context.getBeanDefinitionNames()) {
            log.info("{}", name);
        }
    }

    @PostMapping("/bean1")
    public void printBean1() {
        TestBeanValueConfig bean = applicationContext.getBean(TestBeanValueConfig.class);
        System.out.println(bean.toString());
    }
}
