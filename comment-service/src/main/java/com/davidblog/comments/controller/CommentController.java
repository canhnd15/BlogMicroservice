package com.davidblog.comments.controller;

import com.davidblog.comments.dtos.ApiResponse;
import com.davidblog.comments.dtos.NewCommentSdi;
import com.davidblog.comments.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<?>> addNewComment(@RequestBody @Valid NewCommentSdi sdi) {
        return commentService.addNewComment(sdi);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<ApiResponse<?>> getAllCommentByPost(@PathVariable Long postId) {
        return commentService.getCommentByPost(postId);
    }
}
