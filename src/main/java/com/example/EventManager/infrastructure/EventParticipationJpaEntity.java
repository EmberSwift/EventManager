package com.example.EventManager.infrastructure;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "event_participations")
public class EventParticipationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    public EventParticipationJpaEntity() {}

    public EventParticipationJpaEntity(Long id, Long eventId, Long studentId, LocalDateTime registeredAt) {
        this.id = id;
        this.eventId = eventId;
        this.studentId = studentId;
        this.registeredAt = registeredAt;
    }

}
