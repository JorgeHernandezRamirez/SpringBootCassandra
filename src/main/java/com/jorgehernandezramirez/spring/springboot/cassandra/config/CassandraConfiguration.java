package com.jorgehernandezramirez.spring.springboot.cassandra.config;

import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories(basePackages = "com.jorgehernandezramirez.spring.sprinboot.cassandra.dao.repository")
public class CassandraConfiguration {
}
