package com.slim.playground.service;

import com.slim.playground.config.AutowiredBean;
import com.slim.playground.config.loadConfig.PropertyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrintBeanService implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired
    private AutowiredBean autowiredBean;

    @Autowired
    private AutowiredBean autowiredBean2;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void getEnv() {
        Environment environment = applicationContext.getEnvironment();
        String nickName = environment.getProperty("person.nickName");
        log.info("properties: {}", nickName);

        PropertyBean propertyBean = (PropertyBean) applicationContext.getBean("propertyBean1");
        log.info("propertyBean1: {}", propertyBean);
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

    /*
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
     */
}
