package com.example.EventManager.infrastructure;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "events")
public class EventJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime dateTime;

    // Конструкторы, Геттеры и Сеттеры
    public EventJpaEntity() {}
    public EventJpaEntity(Long id, String title, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
    }
}