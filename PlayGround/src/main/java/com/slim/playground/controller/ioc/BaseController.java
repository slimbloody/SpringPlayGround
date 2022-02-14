package com.slim.playground.controller.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
public class BaseController implements ApplicationContextAware {
    @Autowired
    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // todo: 找到自己创建的bean
        /*
        打印所有bean的信息
        通过 ApplicationContext.getBeanDefinitionNames() 方法获取所有 Bean 的名称；
        通过 ApplicationContext.getBean(beanName) 获取 Bean 的详细信息；
         */
        /*
        找出自己的bean
        Arrays.stream(applicationContext.getBeanDefinitionNames())
            .filter(i -> !(i.startsWith("org.spring") || i.contains("spring")
                || i.contains("jackson") || i.contains("Jackson")
                || i.contains("tomcat") || i.contains("multipart"))
            ).collect(Collectors.toList());
         */
        this.applicationContext = applicationContext;
    }

    @PostMapping("/get_bd_names")
    public String[] getBdNames() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            log.info("{}", name);
        }
        return beanDefinitionNames;
    }

    public String[] getBdNames(ApplicationContext applicationContext) {
        return applicationContext.getBeanDefinitionNames();
    }

    @PostMapping("/debug")
    public void debug() {
        System.out.println("debug");
    }
}
