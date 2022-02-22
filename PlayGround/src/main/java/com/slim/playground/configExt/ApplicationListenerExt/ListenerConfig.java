package com.slim.playground.configExt.ApplicationListenerExt;

import org.springframework.context.annotation.Import;

/**
 ContextRefreshedEvent: 容器刷新完成(所有的bean都完全创建好)
 ContextClosedEvent: 关闭容器会发布这个事件




 1. 事件流程:
 刷新完成以后发布事件
 org.springframework.context.support.AbstractApplicationContext#finishRefresh
 org.springframework.context.support.AbstractApplicationContext#publishEvent(java.lang.Object, org.springframework.core.ResolvableType)

 获取事件多播器, 再去派发事件
 org.springframework.context.event.SimpleApplicationEventMulticaster#multicastEvent(org.springframework.context.ApplicationEvent, org.springframework.core.ResolvableType)
 如果可以异步执行的就异步, 否则同步

 org.springframework.context.event.SimpleApplicationEventMulticaster#doInvokeListener
 拿到 listener 回到 onApplicationEvent方法


 2. multicaster怎么初始化的:
 在初始化容器的时候就有初始化了 事件多播器, 在完成bean对象创建之前就初始化了
 org.springframework.context.support.AbstractApplicationContext#initApplicationEventMulticaster
 如果容器里面又这个bean, 就去容器里面拿
 如果没有就创建一个单实例bean注册到容器里面去
 我们就可以在其他组件要派发事件的时候, 自动注入这个multicaster就行了


 3. 怎么知道容器中哪些listener的?
 首先, listener也是bean

 注册监听器
 org.springframework.context.support.AbstractApplicationContext#registerListeners
 拿到所有的listener, 并且把 listener 注册到 multicaster 中


 spring 里面有一个 AsyncTaskExecutor和SyncTaskExecutor, 可以通过改变executor确定同步异步
 */
@Import(value = {
    MyApplicationListener.class,
    ListenerAnnotationBean.class
})
public class ListenerConfig {
}
