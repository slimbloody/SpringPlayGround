package com.slim.playground.config.addBean;

import com.slim.playground.beans.AutowiredBean;
import com.slim.playground.beans.MyFactoryBean1;
import com.slim.playground.beans.autowiredBean.BeanAnnotateBean;
import com.slim.playground.beans.autowiredBean.OrigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AddBeanConfig {
    @Bean
    @Scope("")
    public Bean1 bean1() {
        return new Bean1();
    }

    // prototype表示每次获得bean都会生成一个新的对象
    @Bean
    @Scope("prototype")
    public Bean2 bean2() {
        return new Bean2();
    }

    @Bean
    @Lazy
    public Bean3 bean3() {
        return new Bean3();
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
