package com.blog.blogrestapi.controller;

import com.blog.blogrestapi.entity.Comment;
import com.blog.blogrestapi.payload.CommentDto;
import com.blog.blogrestapi.service.serviceImpl.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

  public CommentController(CommentService commentService) {
      this.commentService = commentService;

  }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId,commentDto), HttpStatus.CREATED);
    }

}
