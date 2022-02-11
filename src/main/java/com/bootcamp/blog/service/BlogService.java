package com.bootcamp.blog.service;

import com.bootcamp.blog.entity.Blog;

import java.util.List;

public interface BlogService {

    Blog save(Blog blog);

    List<Blog> findBlogByAuthorId(Long authorId);

    List<Blog> findAll();

    Blog findById(Long id);

}
