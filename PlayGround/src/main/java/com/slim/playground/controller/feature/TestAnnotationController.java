package com.slim.playground.controller.feature;

import com.slim.playground.controller.ioc.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestAnnotation")
@Slf4j
public class TestAnnotationController extends BaseController {
    @PostMapping("/autowired")
    public void autowired() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredTestConfig.class);
        log.info("context");
    }
}
