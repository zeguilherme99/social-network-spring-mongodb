package com.learning.socialnetwork.services;

import com.learning.socialnetwork.dto.UserDTO;
import com.learning.socialnetwork.entities.User;
import com.learning.socialnetwork.repositories.UserRepository;
import com.learning.socialnetwork.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public void insert(User obj) {
        userRepository.save(obj);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public void update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        userRepository.save(newObj);
    }

    public void updateData(User updated, User source) {
        updated.setName(source.getName());
        updated.setEmail(source.getEmail());
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
