package com.davidblog.posts.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TagResponseSdo {
    private Long id;
    private String name;
}
