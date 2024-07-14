package com.davidblog.comments.repository;

import com.davidblog.comments.entity.Comment;

import java.util.List;

public interface CommentRepositoryCustom {
    List<Comment> getCommentByPost(Long postId);
}
