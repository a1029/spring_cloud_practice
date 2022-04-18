package com.example.springcloud.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class HeaderConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("header", "header1", "header2");
    }
}
