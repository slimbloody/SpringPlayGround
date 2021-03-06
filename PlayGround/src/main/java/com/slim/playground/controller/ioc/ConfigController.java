package com.slim.playground.controller.ioc;


import com.slim.playground.config.autowiredBean.AutowiredBean;
import com.slim.playground.config.autowiredBean.AutowiredConfig;
import com.slim.playground.config.autowiredBean.ConstructorBean;
import com.slim.playground.config.autowiredBean.ConstructorParamBean;
import com.slim.playground.config.autowiredBean.OrigBean;
import com.slim.playground.config.autowiredBean.SetMethodBean;
import com.slim.playground.config.conditionBean.ConditionBeanConfig;
import com.slim.playground.config.conditionBean.ProfileConfig;
import com.slim.playground.config.importBean.factoryWay.FactoryWayConfig;
import com.slim.playground.config.importBean.factoryWay.GenBean1;
import com.slim.playground.config.importBean.factoryWay.MyFactoryBean1;
import com.slim.playground.config.importBean.importWay.ImportAnnotationConfig;
import com.slim.playground.config.loadConfig.PropertyBean;
import com.slim.playground.config.loadConfig.TestBeanValueConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/config")
public class ConfigController extends BaseController {
    @Autowired
    private Environment env;

    @Autowired
    private AutowiredBean autowiredBean;

    @Autowired
    private AutowiredBean autowiredBean2;

    @PostMapping("/condition")
    public void condition() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ConditionBeanConfig.class,
            ProfileConfig.class
        );
        log.info("=====start context=========");
        for (String name: context.getBeanDefinitionNames()) {
            log.info("{}", name);
        }

        context.close();
    }

    /*
    ?????????????????????
    1. ?????????(@ComponentScan) + ????????????(@Component @Service...)
    2. @Bean: ????????????????????????????????? return new xxx + @Configuration
    3. @Import:
    4. Spring?????????FactoryBean
     */
    @PostMapping("/get_import")
    public void getImport() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportAnnotationConfig.class);
        log.info("=====start context=========");
        for (String name: context.getBeanDefinitionNames()) {
            log.info("{}", name);
        }

        context.close();
    }


    // spring???????????????????????????????????????
    // todo: ??????
    @PostMapping("/get_factory_bean")
    public void getFactoryBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FactoryWayConfig.class);
        //
        List<String> bdNames = Arrays.asList(getBdNames(context))
            .stream()
            .filter(i -> !i.startsWith("org"))
            .collect(Collectors.toList());
        log.info("getBdNames: " + bdNames);

        // ??????getBean?????????????????????bean???????????????
        Object genBean1 = context.getBean(GenBean1.class);
        Object fBean = context.getBean("myFactoryBean1");

        log.info("{}", genBean1.getClass());
        log.info("{}", fBean.getClass());
        log.info("{}", Objects.equals(genBean1, fBean));

        // class com.slim.playground.config.importBean.factoryWay.FactoryBean1
        // ??????bean?????????getObject???????????????
        // ??????singleton?????????false?????????????????????????????? getObject???????????????
        Object factoryClassBean1 = context.getBean(MyFactoryBean1.class);
        Object factoryClassBean2 = context.getBean(MyFactoryBean1.class);
        log.info("{}", factoryClassBean1);
        log.info("{}", factoryClassBean2);
        // ???????????? isSingleton ??????, ?????????, ????????????????????????????????????
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
            // ????????????bean
            log.info("{}", myFactoryBean1.getObject().getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

        context.close();
    }

    @PostMapping("/property")
    public void property() {
        TestBeanValueConfig bean = applicationContext.getBean(TestBeanValueConfig.class);
        log.info("TestBeanValueConfig: {}", bean);

        PropertyBean propertyBean = applicationContext.getBean(PropertyBean.class);
        String nickName1 = propertyBean.getNickName();
        String nickName = env.getProperty("person.nickName");
        log.info("{}", Objects.equals(nickName, nickName1));
    }

    @PostMapping("/autowired")
    public void autowired() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        // BeanAnnotateBean ?????????
        log.info("{}", context.getBean(OrigBean.class));
        log.info("{}", context.getBean(ConstructorBean.class));
        log.info("{}", context.getBean(ConstructorParamBean.class));
        log.info("{}", context.getBean(SetMethodBean.class));
        context.close();
    }

    @PostMapping("/get_autowired_bean")
    public void getAutowiredBean() {
        /*
        1. ???????????????????????????????????????????????????: applicationContext.getBean(AutowiredBean.class);
        2. ??????????????????????????????????????????, ??????????????????????????????id??????????????????
        3. @Qualifier("xxx"), ???????????????id
        4. ?????????????????????????????????????????????, ??????????????????
        @Autowired(required = false), ????????????????????????
        5. @Primary, ????????????????????????????????????
        6. resource???inject???java?????????,???????????????????????????
         */
        log.info(autowiredBean.getLabel());
        log.info(autowiredBean2.getLabel());
    }
}
