package com.learning.socialnetwork.repositories;

import com.learning.socialnetwork.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;

public interface PostRepository extends MongoRepository<Post, String>{

    Set<Post> findByTitleContainingIgnoreCase(String text);
}
