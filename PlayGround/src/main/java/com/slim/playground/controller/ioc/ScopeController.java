package com.slim.playground.controller.ioc;

import com.slim.playground.config.scopeBean.LazyBean;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/scope")
public class ScopeController extends BaseController {
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

    @PostMapping("/get_lazy")
    public void getLazy() {
        boolean flag = false;
        for (String name: applicationContext.getBeanDefinitionNames()) {
            if (Objects.equals(name, "lazyBean")) {
                flag = true;
                break;
            }
        }

        if (flag) {
            log.info("lazyBean beanDefinition exist");
        } else {
            log.info("lazyBean beanDefinition not exist");
        }

        // 直到getBean的时候才执行初始化
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
