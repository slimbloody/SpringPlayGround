package com.slim.playground.controller;

import com.slim.playground.config.loadConfig.TestBeanValueConfig;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/bean_type")
public class BeanTypeController extends BaseController {
    @PostMapping("/get_bd_names")
    public void getBdNames() {
        for (String name: applicationContext.getBeanDefinitionNames()) {
            log.info("{}", name);
        }
    }

    @PostMapping("/bean1")
    public void printBean1() {
        TestBeanValueConfig bean = applicationContext.getBean(TestBeanValueConfig.class);
        System.out.println(bean.toString());
    }

    /*
    @PostMapping("/bean2")
    public void printBean2() {
        service.printBean2();
    }

    @PostMapping("/bean3")
    public void printBean3() {
        service.printBean3();
    }

    @PostMapping("/bean3")
    public void printBean3() {
        service.printBean3();
    }
     */

    @PostMapping("/check_scope")
    public void checkScope() {
        Object bean11 = applicationContext.getBean("bean1");
        Object bean12 = applicationContext.getBean("bean1");
        if (Objects.equals(bean11, bean12)) {
            log.info("bean1 equal");
        } else {
            log.info("bean1 not equal");
        }

        Object bean21 = applicationContext.getBean("bean2");
        Object bean22 = applicationContext.getBean("bean2");
        if (Objects.equals(bean21, bean22)) {
            log.info("bean2 equal");
        } else {
            log.info("bean2 not equal");
        }
    }

    @PostMapping("/get_lazy_false")
    public void getLazy() {
        boolean flag = false;
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "bean3")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("bean3 exist");
        } else {
            log.info("bean3 not exist");
        }

        Object bean3 = applicationContext.getBean("bean3");
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "bean3")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("bean3 exist");
        } else {
            log.info("bean3 not exist");
        }
    }

    @PostMapping("/get_lazy_true")
    public void getTrue() {
        log.info("context load already");
        boolean flag = false;
        // todo: getBeanDefinitionNames 会把lazy的bean初始化
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "bean3")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("bean3 exist");
        } else {
            log.info("bean3 not exist");
        }

        Object bean3 = applicationContext.getBean("bean3");
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "bean3")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("bean3 exist");
        } else {
            log.info("bean3 not exist");
        }
    }
}
