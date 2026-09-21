package com.example.EventAccounting.infrastructure;

import com.example.EventAccounting.application.EnrollStudentToEventService;
import com.example.EventAccounting.application.GetEventParticipantsService;
import com.example.EventAccounting.domain.EventParticipation;
import com.example.EventAccounting.domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participations")
public class ParticipationController {

    private final EnrollStudentToEventService enrollStudentToEventService;
    private final GetEventParticipantsService getEventParticipantsService;

    public ParticipationController(EnrollStudentToEventService enrollStudentToEventService,
                                   GetEventParticipantsService getEventParticipantsService) {
        this.enrollStudentToEventService = enrollStudentToEventService;
        this.getEventParticipantsService = getEventParticipantsService;
    }

    @PostMapping
    public ResponseEntity<EventParticipation> enroll(@RequestParam Long eventId, @RequestParam Long studentId) {
        return ResponseEntity.ok(enrollStudentToEventService.execute(eventId, studentId));
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Student>> getParticipants(@PathVariable Long eventId) {
        return ResponseEntity.ok(getEventParticipantsService.execute(eventId));
    }
}