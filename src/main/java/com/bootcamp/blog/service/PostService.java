package com.bootcamp.blog.service;

import com.bootcamp.blog.entity.Post;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface PostService {

    List<Post> findAll();

    List<Post> findPostByBlogIdAndDate(Long blogId, Date date) throws ParseException;

    Post save(Post post);

    Post findById(Long id);
}
