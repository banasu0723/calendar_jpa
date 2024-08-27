package com.sparta.calendar_jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String username;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;

    @ManyToOne
    @JoinColumn(name = "events_id")
    private Events event;

    @Builder
    public Comment(Long id, String content, String username, LocalDateTime created_date, LocalDateTime updated_date, Events event) {
        this.id = id;
        this.content = content;
        this.username = username;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.event = event;
    }

    public void update(String content, LocalDateTime updated_date) {
        this.content = content;
        this.updated_date = updated_date;
    }

}
