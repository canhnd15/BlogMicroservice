package com.davidblog.posts.controller;

import com.davidblog.general.dtos.ApiResponse;
import com.davidblog.general.dtos.NewPostSdi;
import com.davidblog.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> addNewPost(@RequestBody NewPostSdi sdi) {
        return postService.addNewPost(sdi);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllPost() {
        return postService.getAllPosts();
    }

    @GetMapping("/pagination/")
    public ResponseEntity<ApiResponse<?>> getAllPostWithPagination(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return postService.getPostWithPagination(pageSize, pageNumber);
    }
}
