package com.example.EventManager.application;

import java.time.LocalDateTime;

public record EventResponseDto(
        Long id,
        String title,
        LocalDateTime dateTime) {
}
