package com.bootcamp.blog.controller;

import com.bootcamp.blog.entity.Comment;
import com.bootcamp.blog.entity.Post;
import com.bootcamp.blog.service.CommentService;
import com.bootcamp.blog.service.PostService;
import com.bootcamp.blog.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody @Validated Comment comment){

        Post post = postService.findById(comment.getPost().getId());

        if(!Constant.POST_PUBLISHED.equals(post.getStatus())){
            return new ResponseEntity("Solo se pueden registrar comentarios en post en estado publicado",
                    HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(commentService.save(comment), HttpStatus.ACCEPTED);
    }
}
