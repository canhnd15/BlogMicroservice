package com.davidblog.posts.service;

import com.davidblog.general.dtos.ApiResponse;
import com.davidblog.general.dtos.NewPostSdi;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity<ApiResponse<?>> addNewPost(NewPostSdi sdi);
}
