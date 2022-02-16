package com.slim.playground.extConfig.ApplicationListenerExt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@Slf4j
public class ListenerAnnotationBean {
    @EventListener(classes = {MyApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        log.info("@EventListener: {}", event);
    }
}
/**
 -------------------------------------
 调用起作用的部分:
 EventListenerMethodProcessor 来解析方法上的 @EventListener
 主要是用到了 SmartInitializingSingleton 的原理

 SmartInitializingSingleton.afterSingletonsInstantiated 方法
 会在单实例bean初始化好了以后调用
 Invoked right at the end of the singleton pre-instantiation phase with a guarantee that all regular singleton beans have been created already

 SmartInitializingSingleton接口
 会在单实例bean全部创建完成以后触发
 Callback interface triggered at the end of the singleton pre-instantiation phase 'BeanFactory' bootstrap.

-------------------------------------
 怎么触发的:
 org.springframework.context.support.AbstractApplicationContext#finishBeanFactoryInitialization

 org.springframework.beans.factory.support.DefaultListableBeanFactory#preInstantiateSingletons

 前面先for循环创建所有的单实例bean,
 创建完以后再看单实例bean有没有实现 SmartInitializingSingleton 接口

 然后再调用:
 org.springframework.beans.factory.SmartInitializingSingleton#afterSingletonsInstantiated
 */



