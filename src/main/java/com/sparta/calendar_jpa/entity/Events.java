package com.sparta.calendar_jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "events")
public class Events{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String title;
    private String content;

    private LocalDateTime created_date;  // 작성일
    private LocalDateTime updated_date;  // 수정일

    @Builder
    public Events(Long id, String username, String title, String content, LocalDateTime created_date, LocalDateTime updated_date) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }


    // 수정 메서드
    public void update(String title, String content, LocalDateTime updated_date) {
        this.title = title;
        this.content = content;
        this.updated_date = updated_date;
    }
}
