package com.davidblog.comments.service.impl;

import com.davidblog.comments.common.ResponseCode;
import com.davidblog.comments.dtos.ApiResponse;
import com.davidblog.comments.dtos.NewCommentSdi;
import com.davidblog.comments.dtos.CommentRespSdo;
import com.davidblog.comments.entity.Comment;
import com.davidblog.comments.repository.CommentRepository;
import com.davidblog.comments.service.CommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public ResponseEntity<ApiResponse<?>> addNewComment(NewCommentSdi sdi) {
        Comment comment = Comment.builder()
                .content(sdi.getContent())
                .postId(sdi.getPostId())
                .createAt(new Date())
                .build();

        comment = commentRepository.save(comment);

        return ResponseEntity.ok(ApiResponse.builder()
                        .message("Add new comment successfully!")
                        .data(CommentRespSdo.builder()
                                .id(comment.getId())
                                .content(comment.getContent())
                                .createAt(comment.getCreateAt())
                                .updateAt(comment.getCreateAt())
                                .build())
                        .status(ResponseCode.SUCCESS)
                .build());
    }

    @Override
    public ResponseEntity<ApiResponse<?>> getCommentByPost(Long postId) {
        List<Comment> comments = commentRepository.getCommentByPost(postId);
        List<CommentRespSdo> result = comments.stream().map(comment -> CommentRespSdo.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createAt(comment.getCreateAt())
                .updateAt(comment.getCreateAt())
                .build()).toList();

        return ResponseEntity.ok(ApiResponse.builder()
                        .message("Get list of comments by post successfully!")
                        .data(result)
                        .status(ResponseCode.SUCCESS)
                .build());
    }
}
