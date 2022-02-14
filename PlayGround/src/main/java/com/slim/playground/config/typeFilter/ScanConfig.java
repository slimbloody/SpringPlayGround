package com.slim.playground.config.typeFilter;

import com.slim.playground.controller.ioc.BasicBeanOpController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

// 每个filter只管component里面的value这里的包
@ComponentScans(
    value = {
        // 按顺序从上到下filter
        // 只需要排除的组件
        @ComponentScan(
            value = {"com.slim.basic.spring.mvc"},
            excludeFilters = {
                @ComponentScan.Filter(
                    type = FilterType.CUSTOM,
                    value = {ComponentCustomFilter1.class}
                )
            }
        ),
        // 只需要包含的组件
        // useDefaultFilters = false, 默认规则就是扫描所有的, 禁用掉默认的规则, 只包含才能生效
        @ComponentScan(
            value = {"com.slim.basic.spring.mvc"},
            includeFilters = {
                @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = {RestController.class}),
                @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, classes = {BasicBeanOpController.class})
            },
            useDefaultFilters = false
        )
    }
)
public class ScanConfig {
}
