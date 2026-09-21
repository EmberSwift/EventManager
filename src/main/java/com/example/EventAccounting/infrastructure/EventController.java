package com.example.EventAccounting.infrastructure;
import com.example.EventAccounting.application.EventCreateDto;
import com.example.EventAccounting.application.CancelEventService;
import com.example.EventAccounting.application.CreateEventService;
import com.example.EventAccounting.application.GetUpcomingEventsService;
import com.example.EventAccounting.domain.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final CreateEventService createEventService;
    private final GetUpcomingEventsService getUpcomingEventsService;
    private final CancelEventService cancelEventService;

    public EventController(CreateEventService createEventService,
                           GetUpcomingEventsService getUpcomingEventsService,
                           CancelEventService cancelEventService) {
        this.createEventService = createEventService;
        this.getUpcomingEventsService = getUpcomingEventsService;
        this.cancelEventService = cancelEventService;
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody EventCreateDto dto) {
        return ResponseEntity.ok(createEventService.execute(dto));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(getUpcomingEventsService.execute());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cancelEventService.execute(id);
        return ResponseEntity.noContent().build();
    }
}