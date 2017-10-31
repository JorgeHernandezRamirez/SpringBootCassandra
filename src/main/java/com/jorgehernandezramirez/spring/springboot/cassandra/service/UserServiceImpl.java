package com.jorgehernandezramirez.spring.springboot.cassandra.service;

import com.jorgehernandezramirez.spring.springboot.cassandra.dao.entity.UserEntity;
import com.jorgehernandezramirez.spring.springboot.cassandra.dao.repository.UserRepository;
import com.jorgehernandezramirez.spring.springboot.cassandra.service.dto.UserDto;
import org.apache.commons.lang3.Validate;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    public UserServiceImpl(){
        //Para Spring
    }

    @Override
    public List<UserDto> getUsers() {
        final List<UserDto> userDtoList = new ArrayList<UserDto>();
        userRepository.findAll().forEach(userEntity -> {
            userDtoList.add(mapper.map(userEntity, UserDto.class));
        });
        return userDtoList;
    }

    @Override
    public UserDto getUserFromUUID(UUID id) {
        return mapper.map(userRepository.findOne(id), UserDto.class);
    }

    @Override
    public void save(final UserDto userDto) {
        Validate.notNull(userDto);
        userRepository.save(mapper.map(userDto, UserEntity.class));
    }

    @Override
    public void update(UserDto userDto) {
        save(userDto);
    }

    @Override
    public void delete(final UUID uuid) {
        userRepository.delete(uuid);
    }
}
