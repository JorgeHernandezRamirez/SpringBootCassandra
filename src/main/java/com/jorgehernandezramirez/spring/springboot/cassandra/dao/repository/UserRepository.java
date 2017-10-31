package com.jorgehernandezramirez.spring.springboot.cassandra.dao.repository;

import com.jorgehernandezramirez.spring.springboot.cassandra.dao.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
