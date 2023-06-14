package com.blog.blogrestapi.service.serviceImpl;

import com.blog.blogrestapi.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
}
