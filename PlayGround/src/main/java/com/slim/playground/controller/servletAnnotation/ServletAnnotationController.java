package com.slim.playground.controller.servletAnnotation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 servlet 3.0 需要tomcat 7以上支持, 属于jsr 315系列规范
 jsr 315: Annotation and pluggability
 */
@Slf4j
@RestController
@RequestMapping("/servlet")
public class ServletAnnotationController {
    @PostMapping("/beanFactoryPostProcessor")
    public void beanFactoryPostProcessor() {
    }
}
