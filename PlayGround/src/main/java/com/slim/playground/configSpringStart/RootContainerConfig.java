package com.slim.playground.configSpringStart;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


// 不扫描mvc的组件
@ComponentScan(
    value = "com.slimbloody.playground",
    excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
    }
)
public class RootContainerConfig {
}
