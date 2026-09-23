package com.example.EventManager.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class Event {
    // Getters and Setters
    private final Long id;
    @Setter
    private String title;
    @Setter
    private LocalDateTime dateTime;

    public Event(Long id, String title, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
    }

}