package com.sparta.calendar_jpa.repository;

import com.sparta.calendar_jpa.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByEventId(Long eventId);
}
