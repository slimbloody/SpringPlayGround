package com.slim.playground.extConfig.BeanFactoryPostProcessorExt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
