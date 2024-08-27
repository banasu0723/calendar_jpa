package com.sparta.calendar_jpa.service;

import com.sparta.calendar_jpa.dto.CommentRequestDTO;
import com.sparta.calendar_jpa.dto.CommentResponseDTO;
import com.sparta.calendar_jpa.entity.Comment;
import com.sparta.calendar_jpa.entity.Events;
import com.sparta.calendar_jpa.repository.CommentRepository;
import com.sparta.calendar_jpa.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final EventRepository eventRepository;

    @Transactional
    public CommentResponseDTO createComment(Long eventId, CommentRequestDTO requestDTO) {
        Events event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Comment comment = commentRepository.save(
                Comment.builder()
                        .content(requestDTO.getContent())
                        .username(requestDTO.getUsername())
                        .created_date(LocalDateTime.now())
                        .updated_date(LocalDateTime.now())
                        .event(event)
                        .build()
        );
        return convertToResponseDTO(comment);
    }

    @Transactional
    public CommentResponseDTO getComment(Long id) {
        return commentRepository.findById(id)
                .map(this::convertToResponseDTO)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @Transactional
    public List<CommentResponseDTO> getAllComments(Long eventId) {
        return commentRepository.findByEventId(eventId)
                .stream()
                .map(this::convertToResponseDTO)
                .toList();
    }

    @Transactional
    public CommentResponseDTO updateComment(Long id, CommentRequestDTO requestDTO) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.update(requestDTO.getContent(), LocalDateTime.now());
        return convertToResponseDTO(comment);
    }

    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    private CommentResponseDTO convertToResponseDTO(Comment comment) {
        return CommentResponseDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .username(comment.getUsername())
                .created_date(comment.getCreated_date())
                .updated_date(comment.getUpdated_date())
                .build();
    }
}
