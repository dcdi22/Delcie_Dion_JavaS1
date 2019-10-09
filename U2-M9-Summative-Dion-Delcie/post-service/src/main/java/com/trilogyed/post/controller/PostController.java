package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class PostController {

    @Autowired
    PostDao postDao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post) {
        return postDao.addPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) throws EntityNotFoundException {
        try {
            postDao.getPost(id).getPostID();
        } catch (Exception e) {
            throw new EntityNotFoundException("ID " + id + " does not exist")
        }
        return postDao.getPost(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts() {

    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {

    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public void deletePost(@PathVariable int id) {

    }
}
