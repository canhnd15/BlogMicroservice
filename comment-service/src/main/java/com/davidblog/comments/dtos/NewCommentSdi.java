package com.davidblog.comments.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewCommentSdi {
    @NotBlank(message = "Comment's content is not allowed blank.")
    @NotBlank(message = "Comment's content is required.")
    private String content;

    @NotNull(message = "Post's Id is required.")
    private Long postId;
}
