package com.bootcamp.blog.controller;

import com.bootcamp.blog.entity.Author;
import com.bootcamp.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> findAll(){
        return authorService.finAll();
    }


    @DeleteMapping
    public void delete(@RequestBody Author author) {
        authorService.delete(author);
    }
}
