package com.example.EventAccounting.domain;

import java.time.LocalDateTime;

public class Event {
    private Long id;
    private String title;
    private LocalDateTime dateTime;

    public Event(Long id, String title, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public LocalDateTime getDateTime() { return dateTime; }
    public void setTitle(String title) { this.title = title; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}