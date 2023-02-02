package com.learning.socialnetwork.repositories;

import com.learning.socialnetwork.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Set;

public interface PostRepository extends MongoRepository<Post, String>{

    @Query("{'title': { $regex: ?0, $options: 'i' } }")
    Set<Post> searchTitle(String text);

    Set<Post> findByTitleContainingIgnoreCase(String text);
}
