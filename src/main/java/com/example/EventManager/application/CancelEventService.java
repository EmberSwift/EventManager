package com.example.EventManager.application;

import com.example.EventManager.domain.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class CancelEventService {
    private final EventRepository eventRepository;

    public CancelEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void execute(Long eventId) {
        eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Мероприятие не найдено"));
        eventRepository.deleteById(eventId);
    }
}