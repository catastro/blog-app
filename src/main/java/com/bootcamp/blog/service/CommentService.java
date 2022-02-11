package com.bootcamp.blog.service;

import com.bootcamp.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment save(Comment comment);
}
