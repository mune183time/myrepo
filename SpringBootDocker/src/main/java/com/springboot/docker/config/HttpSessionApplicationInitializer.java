package com.springboot.docker.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class HttpSessionApplicationInitializer
        extends AbstractHttpSessionApplicationInitializer {

    public HttpSessionApplicationInitializer() {
        super(CommonConfiguration.class);
    }
}
