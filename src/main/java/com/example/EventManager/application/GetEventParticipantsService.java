package com.example.EventManager.application;

import com.example.EventManager.domain.ParticipationRepository;
import com.example.EventManager.domain.Student;
import com.example.EventManager.domain.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GetEventParticipantsService {
    private final ParticipationRepository participationRepository;
    private final StudentRepository studentRepository;

    public GetEventParticipantsService(ParticipationRepository participationRepository,
                                       StudentRepository studentRepository) {
        this.participationRepository = participationRepository;
        this.studentRepository = studentRepository;
    }

    public List<Student> execute(Long eventId) {
        return participationRepository.findByEventId(eventId).stream()
                .map(p -> studentRepository.findById(p.studentId()).orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }
}