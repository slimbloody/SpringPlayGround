package com.slim.playground.configExt.BeanFactoryPostProcessorExt;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class BeanDefinitionBean2 {
    private String name;

    public BeanDefinitionBean2(String name) {
        this.name = name;
        log.info("BeanDefinitionBean2 create");
    }

    public BeanDefinitionBean2() {
        log.info("BeanDefinitionBean2 noarg create");
    }
}
