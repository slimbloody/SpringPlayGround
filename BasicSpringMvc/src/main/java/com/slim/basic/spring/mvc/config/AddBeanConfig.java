package com.slim.basic.spring.mvc.config;

import com.slim.basic.spring.mvc.beans.AutowiredBean;
import com.slim.basic.spring.mvc.beans.Bean1;
import com.slim.basic.spring.mvc.beans.Bean2;
import com.slim.basic.spring.mvc.beans.Bean3;
import com.slim.basic.spring.mvc.beans.Bean4;
import com.slim.basic.spring.mvc.beans.LifeCycleAnnotationBean;
import com.slim.basic.spring.mvc.beans.LifeCycleBeanPropertyBean;
import com.slim.basic.spring.mvc.beans.LifeCycleInterfaceBean;
import com.slim.basic.spring.mvc.beans.MyFactoryBean1;
import com.slim.basic.spring.mvc.beans.autowiredBean.BeanAnnotateBean;
import com.slim.basic.spring.mvc.beans.autowiredBean.OrigBean;
import com.slim.basic.spring.mvc.beans.os.WindowsBean;
import com.slim.basic.spring.mvc.beans.os.LinuxBean;
import com.slim.basic.spring.mvc.config.condition.LinuxCondition;
import com.slim.basic.spring.mvc.config.condition.WindowsCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
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
    @ConditionalOnMissingBean(LinuxBean.class)
    public Bean4 bean4() {
        return new Bean4();
    }

    @Bean
    @Conditional({WindowsCondition.class})
    public WindowsBean windowsBean() {
        return new WindowsBean();
    }

    @Bean
    @Conditional({LinuxCondition.class})
    public LinuxBean linuxBean() {
        return new LinuxBean();
    }

    @Bean
    public MyFactoryBean1 myFactoryBean1() {
        return new MyFactoryBean1();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public LifeCycleBeanPropertyBean lifeCycleBean() {
        return new LifeCycleBeanPropertyBean();
    }

    @Bean
    public LifeCycleInterfaceBean lifeCycleInterfaceBean() {
        return new LifeCycleInterfaceBean();
    }

    @Bean
    public LifeCycleAnnotationBean lifeCycleAnnotationBean() {
        return new LifeCycleAnnotationBean();
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
