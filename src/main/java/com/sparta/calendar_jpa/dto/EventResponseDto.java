package com.sparta.calendar_jpa.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EventResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;

    @Builder
    public EventResponseDto(Long id, String username, String title, String content, LocalDateTime created_date, LocalDateTime updated_date) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }
}
