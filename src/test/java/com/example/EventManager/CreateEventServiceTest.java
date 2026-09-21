package com.example.EventManager;

import com.example.EventManager.application.CreateEventService;
import com.example.EventManager.application.EventCreateDto;
import com.example.EventManager.domain.Event;
import com.example.EventManager.domain.EventRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateEventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private CreateEventService createEventService;

    @Test
    @DisplayName("Успешное создание мероприятия (Основной сценарий)")
    void shouldCreateEventSuccessfully() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        EventCreateDto dto = new EventCreateDto("Хакатон", now);
        Event savedEvent = new Event(1L, "Хакатон", now);

        when(eventRepository.save(any(Event.class))).thenReturn(savedEvent);

        // Act
        Event result = createEventService.execute(dto);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("Хакатон");
        verify(eventRepository, times(1)).save(any(Event.class));
    }

    @Test
    @DisplayName("Ошибка при пустом названии мероприятия (Граничный случай)")
    void shouldThrowExceptionWhenTitleIsBlank() {
        // Arrange
        EventCreateDto dto = new EventCreateDto("   ", LocalDateTime.now());

        // Act & Assert
        assertThatThrownBy(() -> createEventService.execute(dto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Название мероприятия не может быть пустым");

        verifyNoInteractions(eventRepository);
    }
}