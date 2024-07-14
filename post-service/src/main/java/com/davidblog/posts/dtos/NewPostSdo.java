package com.davidblog.posts.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
public class NewPostSdo {
    private Long id;
    private String title;
    private String status;
    private String content;
    private String slug;
    private Date createAt;
    private String updateAt;
//    private UserResponseSdo user;
    private List<TagResponseSdo> tags;
}
