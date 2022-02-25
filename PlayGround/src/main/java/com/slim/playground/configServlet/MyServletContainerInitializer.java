package com.slim.playground.configServlet;

import java.util.EnumSet;
import java.util.Set;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.HandlesTypes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;

// todo: 跑不起来
// spring.main.web-application-type: servlet
// SCIs
@HandlesTypes(value = {MyHandlerInterface.class})
@Slf4j
public class MyServletContainerInitializer implements ServletContainerInitializer {
    // Set<Class<?>> set: HandlesTypes 相当于容器启动的时候会讲HandlesTypes指定的这个类型下面的子类(实现类, 子接口)传递过来
    // ServletContext servletContext: 当前web应用的 ServletContext 方法, 一个web应用对应一个context

    // 注册 servlet filter listener
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        log.info("=============== start ServletContainerInitializer ===============");
        set.forEach(i -> log.info("{}", i.getSimpleName()));
        log.info("=============== end ServletContainerInitializer ===============");

        // 要让@WebServlet,@WebListener,@WebServlet生效需要加 @ServletComponentScan 扫描到这些注解

        // 注册主键
        // @WebServlet("/myServlet")
        Dynamic myServlet = servletContext.addServlet("myServlet", new MyServlet());
        // 配置servlet的映射信息
        myServlet.addMapping("/myServlet");

        // @WebListener
        // Listener 可以拿到servletContextEvent, 这里也可以注册组件
        servletContext.addListener(MyServletContextListener.class);


        // @WebServlet
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", new MyFilter());
        myFilter.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true,"myServlet");
        myFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
