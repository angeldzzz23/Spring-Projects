package com.blog.blogrestapi.repository;

import com.blog.blogrestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CommentRepository extends JpaRepository<Comment,Long> {

}
