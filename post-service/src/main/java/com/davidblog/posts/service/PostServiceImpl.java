package com.davidblog.posts.service;

import com.davidblog.posts.common.PostStatus;
import com.davidblog.posts.common.ResponseCode;
import com.davidblog.posts.dtos.ApiResponse;
import com.davidblog.posts.dtos.NewPostSdi;
import com.davidblog.posts.dtos.NewPostSdo;
import com.davidblog.posts.entity.Post;
import com.davidblog.posts.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    @Transactional
    public ResponseEntity<ApiResponse<?>> addNewPost(NewPostSdi sdi) {
        Set<Long> tagIds = sdi.getTagIds();

        Post post = Post.builder()
                .title(sdi.getTitle())
                .status(PostStatus.PENDING)
                .content(sdi.getContent())
                .isDraft(sdi.getIsDraft())
                .slug(sdi.getSlug())
                .createAt(new Date())
                .build();
        post = postRepository.save(post);

        NewPostSdo sdo = NewPostSdo.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .status(post.getStatus())
                .slug(post.getSlug())
                .createAt(post.getCreateAt())
//                .tags()
                .build();

        return ResponseEntity.ok(ApiResponse.builder()
                .message("Add new post successfully!")
                .status(ResponseCode.SUCCESS)
                .data(sdo)
                .build());
    }

    @Override
    public ResponseEntity<ApiResponse<?>> getAllPosts() {
        return ResponseEntity.ok(ApiResponse.builder()
                .message("Get all posts successfully!")
                .status(ResponseCode.SUCCESS)
                .data(postRepository.findAll())
                .build());
    }

    @Override
    public ResponseEntity<ApiResponse<?>> getPostWithPagination(int pageSize, int pageNumber) {
        List<Post> posts = postRepository.getPendingPostWithPagination(pageSize, pageNumber);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Get posts by pagination successfully!")
                        .data(posts)
                        .status(ResponseCode.SUCCESS)
                        .build()
        );
    }
}
