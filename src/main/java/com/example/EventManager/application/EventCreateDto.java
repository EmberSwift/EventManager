package com.example.EventManager.application;

import java.time.LocalDateTime;

public record EventCreateDto(
        String title,
        LocalDateTime dateTime)
{}
