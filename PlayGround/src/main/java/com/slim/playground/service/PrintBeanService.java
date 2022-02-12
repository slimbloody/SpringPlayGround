package com.slim.playground.service;

import com.slim.playground.beans.AutowiredBean;
import com.slim.playground.beans.Bean1;
import com.slim.playground.beans.Bean2;
import com.slim.playground.beans.CalculateComponent;
import com.slim.playground.beans.MyFactoryBean1;
import com.slim.playground.beans.PropertyBean1;
import com.slim.playground.beans.autowiredBean.BeanAnnotateBean;
import com.slim.playground.beans.autowiredBean.ConstructorBean;
import com.slim.playground.beans.autowiredBean.ConstructorParamBean;
import com.slim.playground.beans.autowiredBean.OrigBean;
import com.slim.playground.beans.autowiredBean.SetMethodBean;
import com.slim.playground.config.ImportAnnotationConfig;
import com.slim.playground.config.loadConfig.TestBeanValueConfig;
import com.slim.playground.config.typeFilter.ScanConfig;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrintBeanService implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired
    private CalculateComponent calculateComponent;

    @Autowired
    private Bean1 bean1;

    @Autowired
    private Bean2 bean2;

    @Autowired
    private OrigBean origBean;

    @Autowired
    private AutowiredBean autowiredBean;

    @Autowired
    private AutowiredBean autowiredBean2;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void printBean1() {
        TestBeanValueConfig bean = applicationContext.getBean(TestBeanValueConfig.class);
        System.out.println(bean.toString());
    }

    public void print() {
        for (String name: applicationContext.getBeanDefinitionNames()) {
            log.info("{}", name);
        }
    }

    public void checkScope() {
        Object bean11 = applicationContext.getBean("bean1");
        Object bean12 = applicationContext.getBean("bean1");
        if (Objects.equals(bean11, bean12)) {
            log.info("bean1 equal");
        } else {
            log.info("bean1 not equal");
        }

        Object bean21 = applicationContext.getBean("bean2");
        Object bean22 = applicationContext.getBean("bean2");
        if (Objects.equals(bean21, bean22)) {
            log.info("bean2 equal");
        } else {
            log.info("bean2 not equal");
        }
    }

    public void getLazyTrue() {
        log.info("context load already");
        boolean flag = false;
        // todo: getBeanDefinitionNames 会把lazy的bean初始化
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "bean3")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("bean3 exist");
        } else {
            log.info("bean3 not exist");
        }

        Object bean3 = applicationContext.getBean("bean3");
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "bean3")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("bean3 exist");
        } else {
            log.info("bean3 not exist");
        }
    }

    public void getLazyFalse() {
        boolean flag = false;
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "bean3")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("bean3 exist");
        } else {
            log.info("bean3 not exist");
        }

        Object bean3 = applicationContext.getBean("bean3");
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "bean3")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("bean3 exist");
        } else {
            log.info("bean3 not exist");
        }
    }

    public void componentScans() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanConfig.class);
        for (String name: context.getBeanDefinitionNames()) {
            log.info("{}", name);
        }
    }

    public void getImport() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportAnnotationConfig.class);
        for (String name: context.getBeanDefinitionNames()) {
            log.info("{}", name);
        }
    }

    public void getFactoryBean() {
        Object bean = applicationContext.getBean("myFactoryBean1");
        // class com.slim.playground.beans.FactoryBean1
        // 工厂bean调用的getObject创建的对象
        // 如果singleton改成了false每次都会创建一个新的 getObject创建的对象
        log.info("{}", bean.getClass());

        /*
        BeanFactory
        String FACTORY_BEAN_PREFIX = "&";
        Used to dereference a FactoryBean instance and distinguish it from beans created by the FactoryBean,
        it will return the factory, not the instance returned by the factory
        */
        Object factoryBean = applicationContext.getBean("&myFactoryBean1");
        log.info("{}", factoryBean.getClass());

        // todo: 强转FactoryBean 出错
        MyFactoryBean1 myFactoryBean1 = (MyFactoryBean1) applicationContext.getBean("&myFactoryBean1");
        try {
            // 创建新的bean
            log.info("{}", myFactoryBean1.getObject().getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getEnv() {
        Environment environment = applicationContext.getEnvironment();
        String nickName = environment.getProperty("person.nickName");
        log.info("properties: {}", nickName);

        PropertyBean1 propertyBean1 = (PropertyBean1) applicationContext.getBean("propertyBean1");
        log.info("propertyBean1: {}", propertyBean1);
    }

    public void getAutowiredBean() {
        /*
        1. 默认优先按照类型去容器中找对应组件: applicationContext.getBean(AutowiredBean.class);
        2. 如果找到了多个相同类型的组件, 再将属性名作为组件的id去容器中查找
        3. @Qualifier("xxx"), 指定组件的id
        4. 自动装配默认一定要将属性赋值好, 没有就会报错
        @Autowired(required = false), 不需要一定组装好
        5. @Primary, 自动装配的时候首选的装配
        6. resource和inject是java的规范,也可以实现自动装配
         */
        /*
        1. @Resource: jsr250,按组件名称自动装配, 不支持@Primary和(required=false)
        2. @Inject: jsr330 需要导入javax.inject, 和Autowired功能一样, 不支持required=false
         */
        // AutowiredAnnotationBeanPostProcessor: 解析完成自动装配
        log.info(autowiredBean.getLabel());
        log.info(autowiredBean2.getLabel());
    }

    public void getAutowiredBeanDiff() {
        SetMethodBean setMethodBean = applicationContext.getBean(SetMethodBean.class);
        ConstructorBean constructorBean = applicationContext.getBean(ConstructorBean.class);
        ConstructorParamBean constructorParamBean = applicationContext.getBean(ConstructorParamBean.class);
        BeanAnnotateBean beanAnnotateBean = applicationContext.getBean(BeanAnnotateBean.class);

        log.info("setMethodBean: {}", setMethodBean.toString());
        log.info("constructorBean: {}", constructorBean.toString());
        log.info("constructorParamBean: {}", constructorParamBean.toString());
        log.info("beanAnnotateBean: {}", beanAnnotateBean.toString());
        log.info("origBean: {}", origBean);
    }

    public void printAop() {
        Integer integer1 = calculateComponent.addCalculate(1, 2);
        log.info("cal val: {}", integer1);

        Integer integer2 = calculateComponent.addCalculateThrowException(1, 2);
        log.info("cal val: {}", integer2);
    }
}
