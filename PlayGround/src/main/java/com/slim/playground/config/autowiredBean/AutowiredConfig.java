package com.slim.playground.config.autowiredBean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
    ConstructorBean.class,
    ConstructorParamBean.class,
    BeanAnnotateBean.class,
    SetMethodBean.class
})
public class AutowiredConfig {
}
/*
@Autowired: spring定义的
1. 默认优先按照类型去容器中找对应的组件
2. 如果找到多个相同类型的,再将属性的名称作为组件的id去容器中查找
3. 使用@Qualifier(name=xxx) 指定需要装配组件的id去容器中查找, 而不是使用属性名
4. 自动装配默认一定要将属性赋值好, 没有就会报错, @Autowired(required=false)就不会报错, 为null
5. @Primary: spring 自动装配的时候, 默认用首选的 bean
6. resource和inject是java的规范,也可以实现自动装配
    1. @Resource: jsr250,按组件名称自动装配, 不支持@Primary和(required=false)
    2. @Inject: jsr330 需要导入javax.inject, 和Autowired功能一样, 不支持required=false
 */
// todo: AutowiredAnnotationBeanPostProcessor: 解析完成自动装配

