package com.slim.playground.configSpringStart;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


// 只扫描@controller
@ComponentScan(
    value = "com.slimbloody.playground",
    includeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
    },
    useDefaultFilters = false
)
public class WebContainerConfig {
}
