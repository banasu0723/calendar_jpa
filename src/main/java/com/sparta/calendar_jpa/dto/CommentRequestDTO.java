package com.sparta.calendar_jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDTO {

    private String content;
    private String username;

    @Builder
    public CommentRequestDTO(String content, String username) {
        this.content = content;
        this.username = username;
    }
}
