package com.jorgehernandezramirez.spring.springboot.cassandra.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DozerConfiguration {

    public DozerConfiguration(){
        //Para Spring
    }

    @Bean
    public Mapper buildMapper(){
        return new DozerBeanMapper(Arrays.asList("mapping.xml"));
    }
}
