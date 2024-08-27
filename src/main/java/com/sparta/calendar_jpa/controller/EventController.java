package com.sparta.calendar_jpa.controller;

import com.sparta.calendar_jpa.dto.EventResponseDto;
import com.sparta.calendar_jpa.dto.EventRequestDto;
import com.sparta.calendar_jpa.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventRequestDto requestDTO) {
        EventResponseDto createdEvent = eventService.createEvent(requestDTO);
        return ResponseEntity.ok(createdEvent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEvent(@PathVariable Long id) {
        EventResponseDto event = eventService.getEvent(id);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable Long id, @RequestBody EventRequestDto requestDTO) {
        EventResponseDto updatedEvent = eventService.updateEvent(id, requestDTO);
        return ResponseEntity.ok(updatedEvent);
    }
}
