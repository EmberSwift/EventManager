package com.example.EventAccounting.infrastructure;

import com.example.EventAccounting.domain.EventParticipation;
import com.example.EventAccounting.domain.ParticipationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParticipationRepositoryAdapter implements ParticipationRepository {

    private final SpringDataParticipationRepository springDataRepo;

    public ParticipationRepositoryAdapter(SpringDataParticipationRepository springDataRepo) {
        this.springDataRepo = springDataRepo;
    }

    @Override
    public EventParticipation save(EventParticipation participation) {
        EventParticipationJpaEntity entity = new EventParticipationJpaEntity(
                participation.getId(),
                participation.getEventId(),
                participation.getStudentId(),
                participation.getRegisteredAt()
        );
        EventParticipationJpaEntity saved = springDataRepo.save(entity);
        return new EventParticipation(saved.getId(), saved.getEventId(), saved.getStudentId(), saved.getRegisteredAt());
    }

    @Override
    public boolean existsByEventIdAndStudentId(Long eventId, Long studentId) {
        return springDataRepo.existsByEventIdAndStudentId(eventId, studentId);
    }

    @Override
    public List<EventParticipation> findByEventId(Long eventId) {
        return springDataRepo.findByEventId(eventId).stream()
                .map(e -> new EventParticipation(e.getId(), e.getEventId(), e.getStudentId(), e.getRegisteredAt()))
                .toList();
    }

    @Override
    public List<EventParticipation> findByStudentId(Long studentId) {
        return springDataRepo.findByStudentId(studentId).stream()
                .map(e -> new EventParticipation(e.getId(), e.getEventId(), e.getStudentId(), e.getRegisteredAt()))
                .toList();
    }
}