package com.example.EventAccounting.application;

import java.time.LocalDateTime;

public record EventCreateDto(
        String title,
        LocalDateTime dateTime)
{}
