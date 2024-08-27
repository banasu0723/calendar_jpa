package com.sparta.calendar_jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EventRequestDto {

    private String username;
    private String title;
    private String content;

    @Builder
    public EventRequestDto(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
