package com.slim.playground.controller;


import com.slim.playground.config.conditionBean.ConditionBeanConfig;
import com.slim.playground.config.importBean.factoryWay.GenBean1;
import com.slim.playground.config.importBean.factoryWay.FactoryWayConfig;
import com.slim.playground.config.importBean.factoryWay.MyFactoryBean1;
import com.slim.playground.config.importBean.importWay.ImportAnnotationConfig;
import com.slim.playground.config.loadConfig.TestBeanValueConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
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


    // spring与其他框架整合的时候经常用
    // todo: 例子
    @PostMapping("/get_factory_bean")
    public void getFactoryBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FactoryWayConfig.class);
        //
        List<String> bdNames = Arrays.asList(getBdNames(context))
            .stream()
            .filter(i -> !i.startsWith("org"))
            .collect(Collectors.toList());
        log.info("getBdNames: " + bdNames);

        // 两个getBean实际上拿出来的bean都是一样的
        Object genBean1 = context.getBean(GenBean1.class);
        Object fBean = context.getBean("myFactoryBean1");

        log.info("{}", genBean1.getClass());
        log.info("{}", fBean.getClass());
        log.info("{}", Objects.equals(genBean1, fBean));

        // class com.slim.playground.config.importBean.factoryWay.FactoryBean1
        // 工厂bean调用的getObject创建的对象
        // 如果singleton改成了false每次都会创建一个新的 getObject创建的对象
        Object factoryClassBean1 = context.getBean(MyFactoryBean1.class);
        Object factoryClassBean2 = context.getBean(MyFactoryBean1.class);
        log.info("{}", factoryClassBean1);
        log.info("{}", factoryClassBean2);
        // 如果改了 isSingleton 方法, 则不同, 每次返回的不是同一个实例
        log.info("{}", Objects.equals(factoryClassBean1, factoryClassBean2));

        /*
        BeanFactory
        String FACTORY_BEAN_PREFIX = "&";
        Used to dereference a FactoryBean instance and distinguish it from beans created by the FactoryBean,
        it will return the factory, not the instance returned by the factory
        */
        Object factoryBean = context.getBean("&myFactoryBean1");
        log.info("{}", factoryBean.getClass());

        MyFactoryBean1 myFactoryBean1 = (MyFactoryBean1) context.getBean("&myFactoryBean1");
        try {
            // 创建新的bean
            log.info("{}", myFactoryBean1.getObject().getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/bean1")
    public void printBean1() {
        TestBeanValueConfig bean = applicationContext.getBean(TestBeanValueConfig.class);
        System.out.println(bean.toString());
    }
}
