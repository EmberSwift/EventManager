package com.example.EventAccounting.application;

import com.example.EventAccounting.domain.Event;
import com.example.EventAccounting.domain.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateEventService {
    private final EventRepository eventRepository;

    public CreateEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event execute(EventCreateDto dto) {
        if (dto.title() == null || dto.title().isBlank()) {
            throw new IllegalArgumentException("Название мероприятия не может быть пустым");
        }
        Event event = new Event(null, dto.title(), dto.dateTime());
        return eventRepository.save(event);
    }
}