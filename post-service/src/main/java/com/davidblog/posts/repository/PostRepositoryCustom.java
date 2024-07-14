package com.davidblog.posts.repository;

import com.davidblog.posts.entity.Post;

import java.util.List;

public interface PostRepositoryCustom {
    List<Post> getPendingPostWithPagination(int pageSize, int pageNumber);
}
