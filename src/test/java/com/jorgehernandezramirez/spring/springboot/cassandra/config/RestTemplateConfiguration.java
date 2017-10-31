package com.jorgehernandezramirez.spring.springboot.cassandra.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

@Configuration
public class RestTemplateConfiguration {

    //@Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder().requestFactory(SimpleClientHttpRequestFactory.class);
    }
}
