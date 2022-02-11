package com.bootcamp.blog.controller;

import com.bootcamp.blog.entity.Blog;
import com.bootcamp.blog.entity.Post;
import com.bootcamp.blog.service.BlogService;
import com.bootcamp.blog.service.PostService;
import com.bootcamp.blog.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody @Validated Post post) throws ParseException {
        post.setDate(new Date());
        post.setStatus(Constant.POST_PUBLISHED);

        List<Post> posts = postService.findPostByBlogIdAndDate(post.getBlog().getId(), post.getDate());

        if(posts.size()>=Constant.POST_MAX) {
            return new ResponseEntity("Solo se puede publicar un post por día.", HttpStatus.FORBIDDEN);
        }

        Blog blog = blogService.findById(post.getBlog().getId());

        if (!blog.getStatus().equals(Constant.BLOG_ACTIVE)) {
            return new ResponseEntity("Solo se puede registrar posts en blogs en estado activo.", HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<Post>(postService.save(post), HttpStatus.ACCEPTED);
    }
}
