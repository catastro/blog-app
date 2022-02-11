package com.bootcamp.blog.respository;

import com.bootcamp.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p INNER JOIN p.blog b where b.id = :blogId and p.date=:date")
    List<Post> findPostByBlogIdAndDate(@Param("blogId") Long blogId, @Param("date") Date date);

    void deleteByBlogId(Long blogId);

    List<Post> findByBlogId(Long blogId);
}
