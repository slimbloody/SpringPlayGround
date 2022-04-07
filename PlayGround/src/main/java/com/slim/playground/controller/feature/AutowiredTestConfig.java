package com.slim.playground.controller.feature;

import org.springframework.context.annotation.Import;

@Import(value = {
    BeanA.class,
    BeanB.class,
    CommonBean.class
})
public class AutowiredTestConfig {
}
