package com.dduoming.myproject.gongstagram.dto;

import lombok.Getter;

@Getter
public class CommentDto {
    private String content;
    private Long idx; // 글 id
}
