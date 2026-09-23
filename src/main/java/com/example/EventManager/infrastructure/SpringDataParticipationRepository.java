package com.example.EventManager.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataParticipationRepository extends JpaRepository<EventParticipationJpaEntity, Long> {
    boolean existsByEventIdAndStudentId(Long eventId, Long studentId);
    List<EventParticipationJpaEntity> findByEventId(Long eventId);
    List<EventParticipationJpaEntity> findByStudentId(Long studentId);
}