package com.slim.playground.controller.servlet;


import com.slim.playground.controller.ioc.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 servlet 3.0 需要tomcat 7以上支持, 属于jsr 315系列规范
 jsr 315: Annotation and pluggability
 */
@Slf4j
@RestController
@RequestMapping("/servlet")
public class ServletAnnotationController extends BaseController {
    @PostMapping("/beanFactoryPostProcessor")
    public void beanFactoryPostProcessor() {
    }

    /*

    // shared libraries(共享库) / runtimes pluggability(运行时插件能力)
    1. servlet容器 在启动应用的时候会扫描秒每个jar包的 servletContainerInitializer,
    绑定在 META-INF/services/javax.servlet.ServletContainerInitializer 下面
    文件就会指向 servletContainerInitializer 的实现
    启动并运行这个实现类的方法

    2.

     */
}
