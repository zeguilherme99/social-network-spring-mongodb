package com.learning.socialnetwork.repositories;

import com.learning.socialnetwork.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

}
