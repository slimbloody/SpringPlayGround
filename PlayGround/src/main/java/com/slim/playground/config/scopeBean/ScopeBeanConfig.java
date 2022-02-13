package com.slim.playground.config.scopeBean;

import com.slim.playground.config.AutowiredBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeBeanConfig {
    @Bean
    @Scope("")
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    // prototype表示每次获得bean都会生成一个新的对象
    @Bean
    @Scope("prototype")
    public ProtoTypeBean protoTypeBean() {
        return new ProtoTypeBean();
    }

    @Bean
    @Lazy
    public LazyBean lazyBean() {
        return new LazyBean();
    }

    @Bean("autowiredBean2")
    public AutowiredBean autowiredBean() {
        AutowiredBean autowiredBean = new AutowiredBean();
        autowiredBean.setLabel("2");
        return autowiredBean;
    }

    // @Bean
    // public BeanAnnotateBean beanAnnotateBean(OrigBean origBean) {
    //     BeanAnnotateBean bean = new BeanAnnotateBean();
    //     bean.setOrigBean(origBean);
    //     return bean;
    // }
}
