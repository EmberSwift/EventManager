package com.example.EventManager.application;

import com.example.EventManager.domain.Event;
import com.example.EventManager.domain.EventRepository;
import com.example.EventManager.domain.ParticipationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GetStudentEventsHistoryService {
    private final ParticipationRepository participationRepository;
    private final EventRepository eventRepository;

    public GetStudentEventsHistoryService(ParticipationRepository participationRepository,
                                          EventRepository eventRepository) {
        this.participationRepository = participationRepository;
        this.eventRepository = eventRepository;
    }

    public List<Event> execute(Long studentId) {
        return participationRepository.findByStudentId(studentId).stream()
                .map(p -> eventRepository.findById(p.eventId()).orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }
}