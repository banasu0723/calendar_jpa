package com.sparta.calendar_jpa.controller;

import com.sparta.calendar_jpa.dto.CommentRequestDTO;
import com.sparta.calendar_jpa.dto.CommentResponseDTO;
import com.sparta.calendar_jpa.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDTO> createComment(@PathVariable Long eventId, @RequestBody CommentRequestDTO requestDTO) {
        CommentResponseDTO createdComment = commentService.createComment(eventId, requestDTO);
        return ResponseEntity.ok(createdComment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> getComment(@PathVariable Long id) {
        CommentResponseDTO comment = commentService.getComment(id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDTO>> getAllComments(@PathVariable Long eventId) {
        List<CommentResponseDTO> comments = commentService.getAllComments(eventId);
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> updateComment(@PathVariable Long id, @RequestBody CommentRequestDTO requestDTO) {
        CommentResponseDTO updatedComment = commentService.updateComment(id, requestDTO);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
