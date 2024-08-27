package com.sparta.calendar_jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDTO {

    private Long id;
    private String content;
    private String username;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;

    @Builder
    public CommentResponseDTO(Long id, String content, String username, LocalDateTime created_date, LocalDateTime updated_date) {
        this.id = id;
        this.content = content;
        this.username = username;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }
}
