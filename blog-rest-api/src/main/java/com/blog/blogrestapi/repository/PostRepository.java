package com.blog.blogrestapi.repository;

import com.blog.blogrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
