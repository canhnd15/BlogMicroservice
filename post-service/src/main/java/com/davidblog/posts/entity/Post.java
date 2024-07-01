package com.davidblog.posts.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "status")
    private String status;

    @Column(nullable = false, name = "draft")
    private Boolean isDraft;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "tag_id")
    private Long tagId;
}
