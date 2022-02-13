package com.slim.playground.config.scopeBean;

import com.slim.playground.beans.AutowiredBean;
import com.slim.playground.config.importBean.factoryWay.MyFactoryBean1;
import com.slim.playground.config.autowiredBean.BeanAnnotateBean;
import com.slim.playground.config.autowiredBean.OrigBean;
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

    @Bean
    public MyFactoryBean1 myFactoryBean1() {
        return new MyFactoryBean1();
    }

    @Bean("autowiredBean2")
    public AutowiredBean autowiredBean() {
        AutowiredBean autowiredBean = new AutowiredBean();
        autowiredBean.setLabel("2");
        return autowiredBean;
    }

    @Bean
    public BeanAnnotateBean beanAnnotateBean(OrigBean origBean) {
        BeanAnnotateBean bean = new BeanAnnotateBean();
        bean.setOrigBean(origBean);
        return bean;
    }
}
