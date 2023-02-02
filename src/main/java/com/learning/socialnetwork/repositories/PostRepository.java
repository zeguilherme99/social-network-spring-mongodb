package com.learning.socialnetwork.repositories;

import com.learning.socialnetwork.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>{

}
