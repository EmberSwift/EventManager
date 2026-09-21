package com.example.EventManager.domain;

import java.time.LocalDateTime;

/**
 * @param id Getters
 */
public record EventParticipation(
        Long id,
        Long eventId,
        Long studentId,
        LocalDateTime registeredAt)
{ }
