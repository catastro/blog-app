package com.bootcamp.blog.service.impl;

import com.bootcamp.blog.entity.Post;
import com.bootcamp.blog.respository.PostRepository;
import com.bootcamp.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findPostByBlogIdAndDate(Long blogId, Date date) throws ParseException {
        return postRepository.findPostByBlogIdAndDate(blogId, date);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
