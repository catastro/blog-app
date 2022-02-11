package com.bootcamp.blog.service.impl;

import com.bootcamp.blog.entity.Blog;
import com.bootcamp.blog.respository.BlogRepository;
import com.bootcamp.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> findBlogByAuthorId(Long authorId) {
        return blogRepository.findByAuthorId(authorId);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }
}
