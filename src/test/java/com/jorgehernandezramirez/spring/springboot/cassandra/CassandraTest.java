package com.jorgehernandezramirez.spring.springboot.cassandra;

import com.jorgehernandezramirez.spring.springboot.cassandra.config.RestTemplateConfiguration;
import com.jorgehernandezramirez.spring.springboot.cassandra.service.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(RestTemplateConfiguration.class)
public class CassandraTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void initialization(){
        getAllUserDtos().forEach(userDto -> {
            deleteUser(userDto);
        });
    }

    @Test
    public void shouldGetOneUserAfterInserted() throws Exception {
        saveUserDto(new UserDto(String.valueOf(UUID.randomUUID()), "jorge", "jorge"));
        assertEquals(1, getAllUserDtos().size());
    }

    @Test
    public void shouldGetOneUserAfterInsertedAndDeleted() throws Exception {
        final UserDto userDto = new UserDto(String.valueOf(UUID.randomUUID()), "jorge", "jorge");
        saveUserDto(userDto);
        assertEquals(1, getAllUserDtos().size());
        deleteUser(userDto);
        assertEquals(0, getAllUserDtos().size());
    }

    @Test
    public void shouldUpdateCorrectlyOneUserDto() throws Exception {
        final UserDto userDto = new UserDto(String.valueOf(UUID.randomUUID()), "jorge", "jorge");
        saveUserDto(userDto);
        assertEquals(1, getAllUserDtos().size());
        final UserDto userDtoInserted = getUser(userDto.getId());
        assertEquals(userDtoInserted.getId(), userDto.getId());
        assertEquals(userDtoInserted.getUsername(), userDto.getUsername());
        assertEquals(userDtoInserted.getPassword(), userDto.getPassword());
        userDto.setUsername("jose");
        updateUserDto(userDto);
        assertEquals(userDto.getUsername(), getUser(userDto.getId()).getUsername());
    }

    private void saveUserDto(final UserDto userDto){
        testRestTemplate.postForEntity("/user", userDto, String.class);
    }

    private void updateUserDto(final UserDto userDto){
        testRestTemplate.put("/user", userDto, String.class);
    }

    private List<UserDto> getAllUserDtos(){
        final ResponseEntity<List<UserDto>> userResponse = testRestTemplate.exchange("/user",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDto>>() {
                });
        return userResponse.getBody();
    }

    private void deleteUser(final UserDto userDto){
        testRestTemplate.exchange("/user/" + userDto.getId(),
                HttpMethod.DELETE, null, String.class);
    }

    private UserDto getUser(final String id){
        final ResponseEntity<UserDto> userResponse = testRestTemplate.exchange("/user/" + id,
                HttpMethod.GET, null, UserDto.class);
        return userResponse.getBody();
    }

}
