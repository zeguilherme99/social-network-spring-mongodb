package com.learning.socialnetwork.resources;

import com.learning.socialnetwork.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        User obj = new User(1L, "Maria", "maria@gmail.com");
        User obj2 = new User(2L, "Alex", "maria@gmail.com");
        return new ArrayList<>(Arrays.asList(obj, obj2));
    }
}
