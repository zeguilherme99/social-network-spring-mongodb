package com.learning.socialnetwork.resources;

import com.learning.socialnetwork.dto.UserDTO;
import com.learning.socialnetwork.entities.Post;
import com.learning.socialnetwork.entities.User;
import com.learning.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

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

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO objDTO) {
        User obj = service.fromDTO(objDTO);
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UserDTO objDTO, @PathVariable String id) {
        User obj = service.fromDTO(objDTO);
        obj.setId(id);
        service.update(obj);
    }

    @GetMapping(value = "/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public Set<Post> findPost(@PathVariable String id) {
        User obj = service.findById(id);
        return obj.getPosts();
    }
}
