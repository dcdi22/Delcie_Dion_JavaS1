package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.models.PostViewModel;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.messages.Comment;
import com.trilogyed.stwitter.models.Post;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@CacheConfig(cacheNames = {"posts"})
public class StwitterController {

    @Autowired
    ServiceLayer service;

//    public StwitterController(ServiceLayer service) {
//        this.service = service;
//    }

    // ======== CREATE COMMENT ========

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createComment(@RequestBody Comment comment) {
        service.createComment(comment);
        return comment.getComment();
    }

    // ======== CREATE POST ========

    @CachePut(key = "#result.getPostID()")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public PostViewModel createPost(@RequestBody PostViewModel pvm) {
        return service.createPost(pvm);
    }

    // ======== GET POST ========

    @Cacheable
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int id) {
        return service.getPost(id);
    }

    // ======== GET POST FOR POSTER ========

    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<PostViewModel> getPostsForPoster(@PathVariable String poster_name) {
        return service.getPostsForPoster(poster_name);
    }


    // ================= FOR QUICK TESTING OF WORKING FEIGN CLIENT =================


    //    @Autowired
//    CommentClient commentClient;
//
//    @Autowired
//    PostClient postClient;
//
//    public StwitterController(CommentClient commentClient, PostClient postClient) {
//        this.commentClient = commentClient;
//        this.postClient = postClient;
//    }
//
//    @RequestMapping(value = "/testComment", method = RequestMethod.GET)
//    public List<Comment> getAllComments() {
//        return commentClient.getComments();
//    }
//
//    @RequestMapping(value = "/testPost", method = RequestMethod.GET)
//    public List<Post> getAllPosts() {
//        return postClient.getAllPosts();
//    }
}
