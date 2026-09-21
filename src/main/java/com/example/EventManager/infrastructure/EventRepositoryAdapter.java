package com.example.EventManager.infrastructure;

import com.example.EventManager.domain.Event;
import com.example.EventManager.domain.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventRepositoryAdapter implements EventRepository {
    private final SpringDataEventRepository springDataRepo;

    public EventRepositoryAdapter(SpringDataEventRepository springDataRepo) {
        this.springDataRepo = springDataRepo;
    }

    @Override
    public Event save(Event event) {
        EventJpaEntity entity = new EventJpaEntity(event.getId(), event.getTitle(), event.getDateTime());
        EventJpaEntity saved = springDataRepo.save(entity);
        return new Event(saved.getId(), saved.getTitle(), saved.getDateTime());
    }

    @Override
    public Optional<Event> findById(Long id) {
        return springDataRepo.findById(id)
                .map(e -> new Event(e.getId(), e.getTitle(), e.getDateTime()));
    }

    @Override
    public List<Event> findAll() {
        return springDataRepo.findAll().stream()
                .map(e -> new Event(e.getId(), e.getTitle(), e.getDateTime()))
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        springDataRepo.deleteById(id);
    }
}