package com.blog.blogrestapi.service.serviceImpl;

import com.blog.blogrestapi.payload.CategoryDto;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto getCategory(Long categoryId);
}
