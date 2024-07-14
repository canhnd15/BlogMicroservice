package com.davidblog.comments.service;

import com.davidblog.comments.dtos.ApiResponse;
import com.davidblog.comments.dtos.NewCommentSdi;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    ResponseEntity<ApiResponse<?>> addNewComment(NewCommentSdi sdi);
    ResponseEntity<ApiResponse<?>> getCommentByPost(Long postId);
}
