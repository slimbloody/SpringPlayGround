package com.slim.playground.controller.feature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class BeanB {
    @Autowired
    private CommonBean commonBean;
}
