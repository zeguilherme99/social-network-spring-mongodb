package com.learning.socialnetwork.services;

import com.learning.socialnetwork.entities.Post;
import com.learning.socialnetwork.repositories.PostRepository;
import com.learning.socialnetwork.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    
    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public Set<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }
}
