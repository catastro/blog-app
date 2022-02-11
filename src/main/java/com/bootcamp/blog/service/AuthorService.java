package com.bootcamp.blog.service;

import com.bootcamp.blog.entity.Author;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AuthorService {

    List<Author> finAll();

    Author findById(Long id);

    void delete(@RequestBody Author author);
}
