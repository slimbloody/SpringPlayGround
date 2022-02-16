package com.slim.playground.extConfig.BeanFactoryPostProcessorExt;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class BeanDefinitionBean1 {
    private String name;

    public BeanDefinitionBean1(String name) {
        this.name = name;
        log.info("BeanDefinitionBean1 create");
    }

    public BeanDefinitionBean1() {
        log.info("BeanDefinitionBean1 noarg create");
    }
}
