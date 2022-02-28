package com.slim.playground.config.aopPart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@EnableAspectJAutoProxy
@Import(value = {CalculateAspect.class})
public class AopConfig {
    @Bean
    public CalculateComponent calculateComponent() {
        return new CalculateComponent();
    }
}

// AOP原理: 看给容器中注册了什么组件, 这个组件什么时候工作, 这个组件的功能是什么
/**
 利用
 org.springframework.context.annotation.AspectJAutoProxyRegistrar#registerBeanDefinitions
 自定义给容器中注册bean

 @EnableAspectJAutoProxy 给容器中注册了 AnnotationAwareAspectJAutoProxyCreator 这个bean, 自动代理创建器

 AOP原理:
 1. 看给容器中注册了什么组件 (注解里面import了什么类)
 2. 这个组件什么时候工作 (implement 的地方)
 3. 这个组件的功能是什么 (implement 的地方, 具体做了什么)

 1.
 AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
 org.springframework.aop.config.AopConfigUtils#registerOrEscalateApcAsRequired(Class<?> cls, xxx, xxx)

 -------------------------------------------------------------------------------

 cls=class org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator(是通过函数里面的cls变量传进来的)
 AUTO_PROXY_CREATOR_BEAN_NAME = "org.springframework.aop.config.internalAutoProxyCreator"
 internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator

 给spring注册一个 AnnotationAwareAspectJAutoProxyCreator(注解装配模式的AspectJ切面自动代理创建器)

 第一次进来肯定没有创建这个bean, 所以走下面的逻辑创建
 注册在BeanDefinitionRegistry中

 2. 拿到注解信息:
 AnnotationAttributes enableAspectJAutoProxy =
    AnnotationConfigUtils.attributesFor(importingClassMetadata, EnableAspectJAutoProxy.class);

 3.
 给容器注册一个 AnnotationAwareAspectJAutoProxyCreator
 注解装配模式的, AspectJ切面, 自动代理创建器
 */

/**
AnnotationAwareAspectJAutoProxyCreator 的功能
 AnnotationAwareAspectJAutoProxyCreator
    extends AspectJAwareAdvisorAutoProxyCreator
        extends AbstractAdvisorAutoProxyCreator
            extends AbstractAutoProxyCreator
                extends ProxyProcessorSupport implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
                    SmartInstantiationAwareBeanPostProcessor: 实际上是个后置处理器, 关注后置处理器即可, 即bean初始化前后做的事情
                    BeanFactoryAware: 能传bean工厂进来的
                    extends ProxyConfig

 核心就是作为后置处理器和beanFactory分别做了什么, 打断点进去看一下
 1. 关注后置处理器(在bean初始化前后做的事情)
 2. 自动装配的BeanFactory

 核心思路:
 implement接口才会和容器的交互相关, 所以只要在这些接口方法上面打上断点, 就可以找到对应的调用链路

===================================================
启动流程:
===================================================
 1. 传入配置类, 创建ioc容器
 2. 注册配置类, 调用refresh()刷新容器
 3. 注册bean的后置处理器来方便拦截 bean 的创建

 // Register bean processors that intercept bean creation.
 registerBeanPostProcessors(beanFactory);

 registerBeanPostProcessors具体步骤:
 1. String[] postProcessorNames = beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);
 先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor

 发现postProcessorNames 里面有 org.springframework.aop.config.internalAutoProxyCreator
 上面是注册了这个东西的 beanDefinition, 还没生成具体对象


 2. 给容器中加额外的beanPostProcessor
 int beanProcessorTargetCount = beanFactory.getBeanPostProcessorCount() + 1 + postProcessorNames.length;
 beanFactory.addBeanPostProcessor(new BeanPostProcessorChecker(beanFactory, beanProcessorTargetCount));

 3. 分离那些实现了 PriorityOrdered, Ordered 接口的 BeanPostProcessors 和 其他BeanPostProcessors
 // Separate between BeanPostProcessors that implement PriorityOrdered,
 // Ordered, and the rest.
 List<BeanPostProcessor> priorityOrderedPostProcessors = new ArrayList<>();
 List<BeanPostProcessor> internalPostProcessors = new ArrayList<>();
 List<String> orderedPostProcessorNames = new ArrayList<>();
 List<String> nonOrderedPostProcessorNames = new ArrayList<>();

 优先注册 实现了@PriorityOrdered 的 BeanPostProcessors
 再注册 实现了@Ordered 的 BeanPostProcessors
 最后注册 没实现 优先级(@Order) 的 BeanPostProcessors

 ProxyProcessorSupport 实现了 Order 接口, 所以是走 "再注册"这一步

 4. 注册 BeanPostProcessor, 实际上就是创建 BeanPostProcessor 对象, 保存在容器中
 如果没 get到 就去 创建 internalAutoProxyCreator 的 BeanPostProcessor
 要去创建 internalAutoProxyCreator 的类型是 AnnotationAwareAspectJAutoProxyCreator

 */
