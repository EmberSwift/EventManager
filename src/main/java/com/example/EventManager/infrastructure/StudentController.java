package com.example.EventManager.infrastructure;

import com.example.EventManager.application.StudentCreateDto;
import com.example.EventManager.application.FindStudentsByGroupService;
import com.example.EventManager.application.GetStudentEventsHistoryService;
import com.example.EventManager.application.RegisterStudentService;
import com.example.EventManager.domain.Event;
import com.example.EventManager.domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final RegisterStudentService registerStudentService;
    private final FindStudentsByGroupService findStudentsByGroupService;
    private final GetStudentEventsHistoryService getStudentEventsHistoryService;

    public StudentController(RegisterStudentService registerStudentService,
                             FindStudentsByGroupService findStudentsByGroupService,
                             GetStudentEventsHistoryService getStudentEventsHistoryService) {
        this.registerStudentService = registerStudentService;
        this.findStudentsByGroupService = findStudentsByGroupService;
        this.getStudentEventsHistoryService = getStudentEventsHistoryService;
    }

    @PostMapping
    public ResponseEntity<Student> register(@RequestBody StudentCreateDto dto) {
        return ResponseEntity.ok(registerStudentService.execute(dto));
    }

    @GetMapping("/group/{groupName}")
    public ResponseEntity<List<Student>> getByGroup(@PathVariable String groupName) {
        return ResponseEntity.ok(findStudentsByGroupService.execute(groupName));
    }

    @GetMapping("/{id}/events")
    public ResponseEntity<List<Event>> getEventsHistory(@PathVariable Long id) {
        return ResponseEntity.ok(getStudentEventsHistoryService.execute(id));
    }
}