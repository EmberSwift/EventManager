package com.example.EventManager.domain;

import java.util.List;

public interface ParticipationRepository {
    EventParticipation save(EventParticipation participation);
    boolean existsByEventIdAndStudentId(Long eventId, Long studentId);
    List<EventParticipation> findByEventId(Long eventId);
    List<EventParticipation> findByStudentId(Long studentId);
}
