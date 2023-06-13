package com.blog.blogrestapi.service.serviceImpl;

import com.blog.blogrestapi.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);


}
