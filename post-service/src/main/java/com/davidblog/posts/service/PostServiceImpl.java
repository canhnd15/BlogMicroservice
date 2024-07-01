package com.davidblog.posts.service;

import com.davidblog.general.common.PostStatus;
import com.davidblog.general.common.ResponseCode;
import com.davidblog.general.dtos.ApiResponse;
import com.davidblog.general.dtos.NewPostSdi;
import com.davidblog.general.dtos.NewPostSdo;
import com.davidblog.posts.entity.Post;
import com.davidblog.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    @Transactional
    public ResponseEntity<ApiResponse<?>> addNewPost(NewPostSdi sdi) {
        Post post = Post.builder()
                .title(sdi.getTitle())
                .content(sdi.getContent())
                .status(PostStatus.PENDING)
                .isDraft(sdi.getIsDraft())
                .slug(sdi.getSlug())
                .createAt(new Date())
                .build();
        post = postRepository.save(post);

        postRepository.save(post);

        NewPostSdo sdo = NewPostSdo.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .status(post.getStatus())
                .build();

        return ResponseEntity.ok(ApiResponse.builder()
                        .message("Add new post successfully!")
                        .status(ResponseCode.SUCCESS)
                        .data(sdo)
                .build());
    }
}
