package com.blog.blogrestapi.service.serviceImpl;

import com.blog.blogrestapi.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(Long postId, Long commentId);


    CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest);
}
