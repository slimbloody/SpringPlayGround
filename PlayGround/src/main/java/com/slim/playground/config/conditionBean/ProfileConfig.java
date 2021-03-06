package com.slim.playground.config.conditionBean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;


/*
设置profile的方法:
1. -Dspring.profiles.active=test,pre
2. 代码方式
applicationContext.getEnvironment().setActiveProfiles("test", "dev");
applicationContext.register(ProfileConfig.class);
applicationContext.refresh();
 */

@PropertySource("classpath:/person.properties")
public class ProfileConfig implements EmbeddedValueResolverAware {
    private StringValueResolver valueResolver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
    }

    // 默认的环境叫default
    @Profile({"default", "test"})
    @Qualifier("profileBean1")
    public ProfileBean profileBean1(@Value("${db.test.env}") String env) {
        return new ProfileBean(env, valueResolver.resolveStringValue("${db.test.name}"));
    }

    @Profile("pre")
    @Qualifier("profileBean2")
    public ProfileBean profileBean2(@Value("${db.pre.env}") String env) {
        return new ProfileBean(env, valueResolver.resolveStringValue("${db.pre.name}"));
    }

    @Profile("prd")
    @Qualifier("profileBean3")
    public ProfileBean profileBean3(@Value("${db.prd.env}") String env) {
        return new ProfileBean(env, valueResolver.resolveStringValue("${db.prd.name}"));
    }
}
