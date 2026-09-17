package com.example.EventAccounting.domain;

import java.time.LocalDateTime;

public class EventParticipation {
    private Long id;
    private Long eventId;
    private Long studentId;
    private LocalDateTime registeredAt;

    public EventParticipation(Long id, Long eventId, Long studentId, LocalDateTime registeredAt) {
        this.id = id;
        this.eventId = eventId;
        this.studentId = studentId;
        this.registeredAt = registeredAt;
    }

    // Getters
    public Long getId() { return id; }
    public Long getEventId() { return eventId; }
    public Long getStudentId() { return studentId; }
    public LocalDateTime getRegisteredAt() { return registeredAt; }
}
