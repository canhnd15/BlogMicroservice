package com.davidblog.comments.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class CommentRespSdo {
    private Long id;
    private String content;
    private Date createAt;
    private Date updateAt;
}
