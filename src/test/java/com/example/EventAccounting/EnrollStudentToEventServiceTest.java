package com.example.EventAccounting;

import com.example.EventAccounting.application.EnrollStudentToEventService;
import com.example.EventAccounting.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnrollStudentToEventServiceTest {

    @Mock
    private EventRepository eventRepository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private ParticipationRepository participationRepository;

    @InjectMocks
    private EnrollStudentToEventService enrollService;

    @Test
    @DisplayName("Успешная запись студента на мероприятие")
    void shouldEnrollStudentSuccessfully() {
        // Arrange
        Long eventId = 1L;
        Long studentId = 2L;

        when(eventRepository.findById(eventId))
                .thenReturn(Optional.of(new Event(eventId, "Лекция", LocalDateTime.now())));
        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(new Student(studentId, "Иван Иванов", "BSO-01")));
        when(participationRepository.existsByEventIdAndStudentId(eventId, studentId))
                .thenReturn(false);
        when(participationRepository.save(any(EventParticipation.class)))
                .thenReturn(new EventParticipation(10L, eventId, studentId, LocalDateTime.now()));

        // Act
        EventParticipation result = enrollService.execute(eventId, studentId);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getEventId()).isEqualTo(eventId);
        assertThat(result.getStudentId()).isEqualTo(studentId);
    }

    @Test
    @DisplayName("Ошибка при попытке повторной записи")
    void shouldThrowExceptionWhenStudentAlreadyEnrolled() {
        // Arrange
        Long eventId = 1L;
        Long studentId = 2L;

        when(eventRepository.findById(eventId))
                .thenReturn(Optional.of(new Event(eventId, "Лекция", LocalDateTime.now())));
        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(new Student(studentId, "Иван Иванов", "BSO-01")));
        when(participationRepository.existsByEventIdAndStudentId(eventId, studentId))
                .thenReturn(true);

        // Act & Assert
        assertThatThrownBy(() -> enrollService.execute(eventId, studentId))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Студент уже зарегистрирован на мероприятие");

        verify(participationRepository, never()).save(any());
    }
}