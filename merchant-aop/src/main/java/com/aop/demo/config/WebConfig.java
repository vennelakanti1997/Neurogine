package com.aop.demo.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private transient AuditInterceptor auditInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(auditInterceptor);
    }
}
