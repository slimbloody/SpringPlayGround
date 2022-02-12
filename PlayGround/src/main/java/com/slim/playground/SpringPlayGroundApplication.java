package com.slim.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
给容器注册组件
1. 包扫描(@ComponentScan) + 标注注解(@Component @Service...)
2. @Bean: 导入第三方包里面的组件 return new xxx + @Configuration
3. @Import:
4. Spring提供的FactoryBean
 */
@SpringBootApplication
public class SpringPlayGroundApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringPlayGroundApplication.class, args);
        } catch (Throwable throwable) {
            System.out.println("failed");
        }
    }
}
