package com.learning.socialnetwork.resources;

import com.learning.socialnetwork.entities.Post;
import com.learning.socialnetwork.resources.util.URL;
import com.learning.socialnetwork.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Set;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping(value = "/titlesearch", params = "text")
    @ResponseStatus(HttpStatus.OK)
    public Set<Post> findByTitle(String text) {
        text = URL.decodeParam(text);
        return service.findByTitle(text);
    }

    @GetMapping(value = "/fullsearch")
    @ResponseStatus(HttpStatus.OK)
    public Set<Post> fullSearch(@RequestParam(value = "text", defaultValue ="") String text, @RequestParam(value = "minDate", defaultValue ="") String minDate, @RequestParam(value = "maxDate", defaultValue ="") String maxDate) {
        text = URL.decodeParam(text);
        Instant min = URL.convertInstant(minDate);
        Instant max = URL.convertInstant(maxDate);
        return service.fullSearch(text, min, max);
    }
}
