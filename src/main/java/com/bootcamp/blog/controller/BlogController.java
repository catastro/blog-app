package com.bootcamp.blog.controller;

import com.bootcamp.blog.entity.Author;
import com.bootcamp.blog.entity.Blog;
import com.bootcamp.blog.service.AuthorService;
import com.bootcamp.blog.service.BlogService;
import com.bootcamp.blog.util.Constant;
import com.bootcamp.blog.util.UtilDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody @Validated Blog blog){

        List<Blog> blogs = blogService.findBlogByAuthorId(blog.getAuthor().getId());

        if (blogs.size() >= Constant.BLOG_MAX) {
            return new ResponseEntity("Un autor solo pude tener maximo 03 blogs", HttpStatus.FORBIDDEN);
        }

        Author author = authorService.findById(blog.getAuthor().getId());

        if (UtilDate.getDifferenceDays(new Date(), author.getBirthDate()) <= Constant.MAX_AUTHOR_AGE) {
            return new ResponseEntity("Solo pueden tener blogs los autores mayores de 18 años", HttpStatus.FORBIDDEN);
        }

        blog.setStatus(Constant.BLOG_ACTIVE);
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<Blog> findAll(){
        return blogService.findAll();
    }
}
