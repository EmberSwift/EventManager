package com.example.EventAccounting.infrastructure;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public LocalDateTime getRegisteredAt() { return registeredAt; }
    public void setRegisteredAt(LocalDateTime registeredAt) { this.registeredAt = registeredAt; }
}
