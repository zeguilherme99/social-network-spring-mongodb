package com.learning.socialnetwork.resources;

import com.learning.socialnetwork.dto.UserDTO;
import com.learning.socialnetwork.entities.User;
import com.learning.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAll() {
        List<User> list = service.findAll();
        return list.stream().map(UserDTO::new).toList();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(@PathVariable String id) {
        User obj = service.findById(id);
        return new UserDTO(obj);
    }
}
