package com.learning.socialnetwork.repositories;

import com.learning.socialnetwork.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.util.Set;

public interface PostRepository extends MongoRepository<Post, String>{

    @Query("{'title': { $regex: ?0, $options: 'i' } }")
    Set<Post> searchTitle(String text);

    Set<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ $and: [ { moment: { $gte: ?1 } }, { moment: { $lte: ?2 } } , { $or: [ {'title': { $regex: ?0, $options: 'i' } }, {'body': { $regex: ?0, $options: 'i' } }, {'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    Set<Post> fullSearch(String text, Instant minDate, Instant maxDate);
}
