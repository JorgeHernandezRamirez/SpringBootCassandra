package com.jorgehernandezramirez.spring.springboot.cassandra.rest;

import com.jorgehernandezramirez.spring.springboot.cassandra.service.IUserService;
import com.jorgehernandezramirez.spring.springboot.cassandra.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private IUserService userService;

    public UserRest(){
        //Para Spring
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable final UUID id){
        return userService.getUserFromUUID(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody final UserDto userDto){
        userService.save(userDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody final UserDto userDto){
        userService.update(userDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable final UUID id){
        userService.delete(id);
    }
}
