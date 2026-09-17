package com.example.EventAccounting.application;

import com.example.EventAccounting.domain.ParticipationRepository;
import com.example.EventAccounting.domain.Student;
import com.example.EventAccounting.domain.StudentRepository;
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
                .map(p -> studentRepository.findById(p.getStudentId()).orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }
}