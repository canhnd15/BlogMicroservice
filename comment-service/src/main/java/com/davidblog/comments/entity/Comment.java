package com.davidblog.comments.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
