package com.bootcamp.blog.service.impl;

import com.bootcamp.blog.entity.Author;
import com.bootcamp.blog.entity.Blog;
import com.bootcamp.blog.entity.Comment;
import com.bootcamp.blog.entity.Post;
import com.bootcamp.blog.respository.AuthorRepository;
import com.bootcamp.blog.respository.BlogRepository;
import com.bootcamp.blog.respository.CommentRepository;
import com.bootcamp.blog.respository.PostRepository;
import com.bootcamp.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    PostRepository postRepository;


    @Override
    public List<Author> finAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Author author) {

        List<Blog> blogs = blogRepository.findByAuthorId(author.getId());

        List<Post> posts = new ArrayList<>();

        blogs.forEach(blog -> {
            posts.addAll(postRepository.findByBlogId(blog.getId()));
        });

        //comentarios
        posts.forEach(post -> {
            commentRepository.deleteByPostId(post.getId());
        });

        //post
        blogs.forEach(blog -> {
            postRepository.deleteByBlogId(blog.getId());
        });


        //blog
        blogRepository.deleteByAuthorId(author.getId());
        //author
        authorRepository.deleteById(author.getId());

    }
}
