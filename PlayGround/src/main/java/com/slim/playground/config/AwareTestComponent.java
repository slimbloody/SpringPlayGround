package com.slim.playground.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Slf4j
@Component
public class AwareTestComponent implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    /*
    把spring底层的一些组件注入到Bean中
    看到了实现了Aware接口, 就把xxxAwareProcessor传进来
    aware的processor里面会通过aware接口调用set方法
     */
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        log.info("name: {}", name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("osName: ${os.name}, springEval: #{20 * 18}");
        log.info("resolver: {}", s);
    }
}
