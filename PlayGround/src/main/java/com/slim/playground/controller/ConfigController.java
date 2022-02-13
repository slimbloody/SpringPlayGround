package com.slim.playground.controller;


import com.slim.playground.config.conditionBean.ConditionBeanConfig;
import com.slim.playground.config.loadConfig.TestBeanValueConfig;
import com.slim.playground.config.importBean.ImportAnnotationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/config")
public class ConfigController extends BaseController {
    @PostMapping("/condition")
    public void condition() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionBeanConfig.class);
        log.info("=====start context=========");
        for (String name: context.getBeanDefinitionNames()) {
            log.info("{}", name);
        }
    }

    /*
    给容器注册组件
    1. 包扫描(@ComponentScan) + 标注注解(@Component @Service...)
    2. @Bean: 导入第三方包里面的组件 return new xxx + @Configuration
    3. @Import:
    4. Spring提供的FactoryBean
     */
    @PostMapping("/get_import")
    public void getImport() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportAnnotationConfig.class);
        log.info("=====start context=========");
        for (String name: context.getBeanDefinitionNames()) {
            log.info("{}", name);
        }
    }

    @PostMapping("/bean1")
    public void printBean1() {
        TestBeanValueConfig bean = applicationContext.getBean(TestBeanValueConfig.class);
        System.out.println(bean.toString());
    }
}
