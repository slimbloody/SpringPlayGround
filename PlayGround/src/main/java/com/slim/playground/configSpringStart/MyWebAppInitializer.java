package com.slim.playground.configSpringStart;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// todo: 没有启动测试
// web容器启动时创建对象
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 获取根容器的配置类: spring配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootContainerConfig.class};
    }

    // 获取web容器的配置类: springMVC配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebContainerConfig.class};
    }

    // 获取DispatchServlet的映射信息: 即拦截什么请求
    // return new String[]{"/"}; 拦截包括静态资源的所有请求, 不包括jsp
    // return new String[]{"/*"}; 拦截包括静态资源的所有请求, 包括jsp
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
