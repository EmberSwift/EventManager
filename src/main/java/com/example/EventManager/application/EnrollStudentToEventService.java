package com.example.EventManager.application;

import com.example.EventManager.domain.EventParticipation;
import com.example.EventManager.domain.EventRepository;
import com.example.EventManager.domain.ParticipationRepository;
import com.example.EventManager.domain.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnrollStudentToEventService {
    private final EventRepository eventRepository;
    private final StudentRepository studentRepository;
    private final ParticipationRepository participationRepository;

    public EnrollStudentToEventService(EventRepository eventRepository,
                                       StudentRepository studentRepository,
                                       ParticipationRepository participationRepository) {
        this.eventRepository = eventRepository;
        this.studentRepository = studentRepository;
        this.participationRepository = participationRepository;
    }

    public EventParticipation execute(Long eventId, Long studentId) {
        eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Мероприятие не найдено"));
        studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Студент не найден"));

        if (participationRepository.existsByEventIdAndStudentId(eventId, studentId)) {
            throw new IllegalStateException("Студент уже зарегистрирован на мероприятие");
        }

        EventParticipation participation = new EventParticipation(null, eventId, studentId, LocalDateTime.now());
        return participationRepository.save(participation);
    }
}