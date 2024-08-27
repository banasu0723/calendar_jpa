package com.sparta.calendar_jpa.service;

import com.sparta.calendar_jpa.dto.EventRequestDto;
import com.sparta.calendar_jpa.dto.EventResponseDto;
import com.sparta.calendar_jpa.entity.Events;
import com.sparta.calendar_jpa.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    @Transactional
    public EventResponseDto createEvent(EventRequestDto requestDTO) {
        Events event = eventRepository.save(
                Events.builder()
                        .username(requestDTO.getUsername())
                        .title(requestDTO.getTitle())
                        .content(requestDTO.getContent())
                        .created_date(LocalDateTime.now())
                        .updated_date(LocalDateTime.now())
                        .build()
        );
        return convertToResponseDto(event);
    }

    @Transactional(readOnly = true)
    public EventResponseDto getEvent(Long id) {
        return eventRepository.findById(id)
                .map(this::convertToResponseDto)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Transactional
    public EventResponseDto updateEvent(Long id, EventRequestDto requestDTO) {
        Events event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.update(requestDTO.getTitle(), requestDTO.getContent(), LocalDateTime.now());

        return convertToResponseDto(event);
    }

    private EventResponseDto convertToResponseDto(Events event) {
        return EventResponseDto.builder()
                .id(event.getId())
                .username(event.getUsername())
                .title(event.getTitle())
                .content(event.getContent())
                .created_date(event.getCreated_date())
                .updated_date(event.getUpdated_date())
                .build();
    }
}
