package com.slim.playground.controller.ext;

import com.slim.playground.controller.ioc.BaseController;
import com.slim.playground.configExt.ApplicationListenerExt.ListenerConfig;
import com.slim.playground.configExt.ApplicationListenerExt.MyApplicationEvent;
import com.slim.playground.configExt.BeanFactoryPostProcessorExt.BeanFactoryPostProcessorConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ext")
public class ExtController extends BaseController {
    @PostMapping("/beanFactoryPostProcessor")
    public void beanFactoryPostProcessor() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfig.class);
        context.close();
    }

    @PostMapping("/listener")
    public void listener() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ListenerConfig.class);
        context.publishEvent(new MyApplicationEvent("goods"));
        context.close();
    }
}

