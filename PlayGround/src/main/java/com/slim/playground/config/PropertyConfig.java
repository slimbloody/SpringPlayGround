package com.slim.playground.config;

import com.slim.playground.beans.PropertyBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// 使用PropertySource 读取外部配置文件中的k/v保存到运行的环境变量中
@Configuration
@PropertySources(value = {
    @PropertySource(value={"classpath:/person.properties"})
})
public class PropertyConfig {
    @Bean
    public PropertyBean1 propertyBean1() {
        return new PropertyBean1();
    }
}
