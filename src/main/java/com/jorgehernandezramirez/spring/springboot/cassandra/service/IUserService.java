package com.jorgehernandezramirez.spring.springboot.cassandra.service;

import com.jorgehernandezramirez.spring.springboot.cassandra.service.dto.UserDto;

import java.util.List;
import java.util.UUID;

/**
 * Api de usuarios
 */
public interface IUserService {

    /**
     * Método que debe devolver el lista de todos los usuarios
     * @return
     */
    List<UserDto> getUsers();

    /**
     * Método que debe devolver un usuario a partir del nombre de usuario
     * @return
     */
    UserDto getUserFromUUID(UUID id);

    /**
     * Método que debe guardar un usuario en el sistema
     * @param userDto
     */
    void save(UserDto userDto);

    /**
     * Método que debe actualizar un usuario en el sistema
     * @param userDto
     */
    void update(UserDto userDto);

    /**
     * Método que debe borrar un usuario
     * @param uuid
     */
    void delete(UUID uuid);
}
