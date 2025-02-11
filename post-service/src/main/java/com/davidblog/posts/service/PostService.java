package com.davidblog.posts.service;

import com.davidblog.posts.dtos.ApiResponse;
import com.davidblog.posts.dtos.NewPostSdi;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity<ApiResponse<?>> addNewPost(NewPostSdi sdi);
    ResponseEntity<ApiResponse<?>> getAllPosts();
    ResponseEntity<ApiResponse<?>> getPostWithPagination(int pageSize, int pageNumber);
}
