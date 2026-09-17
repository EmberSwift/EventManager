package com.example.EventAccounting.application;

import com.example.EventAccounting.domain.Event;
import com.example.EventAccounting.domain.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUpcomingEventsService {
    private final EventRepository eventRepository;

    public GetUpcomingEventsService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> execute() {
        return eventRepository.findAll();
    }
}
