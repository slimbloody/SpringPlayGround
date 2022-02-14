package com.slim.playground.config.lifeCycle;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Slf4j
@Component
public class AwareTestComponent implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    /*
    把spring底层的一些组件注入到Bean中
    看到了实现了Aware接口, 就把xxxAwareProcessor传进来
    aware的processor里面会通过aware接口调用set方法
     */
    @Autowired
    private ApplicationContext applicationContext;

    /*
    Set the name of the bean in the bean factory that created this bean.
    Invoked after population of normal bean properties but before an init
    callback such as InitializingBean.afterPropertiesSet() or a custom
    init-method.

    Params:
        name – the name of the bean in the factory. Note that this name
        is the actual bean name used in the factory, which may differ from
        the originally specified name: in particular for inner bean names,
        the actual bean name might have been made unique through appending
        "#..." suffixes. Use the BeanFactoryUtils.originalBeanName(String)
        method to extract the original bean name (without suffix),if desired.
     */
    @Override
    public void setBeanName(String name) {
        log.info("name: {}", name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("osName: ${os.name}, springEval: #{20 * 18}");
        log.info("resolver: {}", s);
    }
}
