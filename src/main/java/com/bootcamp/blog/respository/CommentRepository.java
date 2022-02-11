package com.bootcamp.blog.respository;

import com.bootcamp.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteByPostId(Long postId);

}
