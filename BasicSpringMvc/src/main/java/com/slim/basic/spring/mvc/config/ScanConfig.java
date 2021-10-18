package com.slim.basic.spring.mvc.config;


import com.slim.basic.spring.mvc.typeFilter.ComponentCustomFilter1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;

@ComponentScans(
    value = {
        // 按顺序从上到下filter
        @ComponentScan(
            value = {"com.slim.basic.spring.mvc"},
            excludeFilters = {
                @ComponentScan.Filter(
                    type = FilterType.CUSTOM,
                    value = {ComponentCustomFilter1.class}
                )
            }
        )
        // ,@ComponentScan(
        //     value = {"com.slim.basic.spring.mvc"},
        //     includeFilters = {
        //         @ComponentScan.Filter()
        //     },
        //     useDefaultFilters = false
        // )
    }
)
public class ScanConfig {
}
