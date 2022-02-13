package com.slim.playground.controller;

import com.slim.playground.config.scopeBean.LazyBean;
import com.slim.playground.config.scopeBean.ProtoTypeBean;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/scope")
public class ScopeController extends BaseController {
    @Autowired
    private ProtoTypeBean bean;

    @PostMapping("/get_bd_names")
    public void getBdNames() {
        for (String name: applicationContext.getBeanDefinitionNames()) {
            log.info("{}", name);
        }
    }

    @PostMapping("/check_scope")
    public void checkScope() {
        Object bean11 = applicationContext.getBean("singletonBean");
        Object bean12 = applicationContext.getBean("singletonBean");
        if (Objects.equals(bean11, bean12)) {
            log.info("singletonBean equal");
        } else {
            log.info("singletonBean not equal");
        }

        Object bean21 = applicationContext.getBean("protoTypeBean");
        Object bean22 = applicationContext.getBean("protoTypeBean");
        if (Objects.equals(bean21, bean22)) {
            log.info("protoTypeBean equal");
        } else {
            log.info("protoTypeBean not equal");
        }
    }

    @PostMapping("/get_lazy_false")
    public void getLazy() {
        boolean flag = false;
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "lazyBean")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("lazyBean exist");
        } else {
            log.info("lazyBean not exist");
        }

        LazyBean lazyBean = (LazyBean) applicationContext.getBean("lazyBean");
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "lazyBean")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("lazyBean exist");
        } else {
            log.info("lazyBean not exist");
        }
    }

    @PostMapping("/get_lazy_true")
    public void getTrue() {
        log.info("context load already");
        boolean flag = false;
        // todo: getBeanDefinitionNames 会把lazy的bean初始化
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "lazyBean")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("lazyBean exist");
        } else {
            log.info("lazyBean not exist");
        }

        LazyBean lazyBean = (LazyBean) applicationContext.getBean("lazyBean");
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "lazyBean")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("lazyBean exist");
        } else {
            log.info("lazyBean not exist");
        }
    }
}
