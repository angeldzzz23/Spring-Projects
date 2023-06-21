package com.blog.blogrestapi.service.serviceImpl;

import com.blog.blogrestapi.payload.PostDto;
import com.blog.blogrestapi.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
    List<PostDto> getPostsByCategory(Long categoryId);


}
