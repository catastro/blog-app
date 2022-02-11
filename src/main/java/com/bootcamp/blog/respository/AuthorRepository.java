package com.bootcamp.blog.respository;

import com.bootcamp.blog.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
