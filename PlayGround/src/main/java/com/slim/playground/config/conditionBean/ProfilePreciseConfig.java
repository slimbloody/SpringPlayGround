package com.slim.playground.config.conditionBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

@PropertySource("classpath:/person.properties")
public class ProfilePreciseConfig {
    // 默认的环境叫default
    @Profile({"default", "test"})
    @Qualifier("profileBean1")
    public ProfileBean profileBean1(@Value("${db.test.env}") String env) {
        return new ProfileBean(env, "t1");
    }

    @Profile("pre")
    @Qualifier("profileBean2")
    public ProfileBean profileBean2(@Value("${db.pre.env}") String env) {
        return new ProfileBean(env, "p1");
    }

    @Profile("prd")
    @Qualifier("profileBean3")
    public ProfileBean profileBean3(@Value("${db.prd.env}") String env) {
        return new ProfileBean(env, "p");
    }
}
