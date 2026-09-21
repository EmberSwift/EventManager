package com.example.EventManager.application;

import com.example.EventManager.domain.Student;
import com.example.EventManager.domain.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindStudentsByGroupService {
    private final StudentRepository studentRepository;

    public FindStudentsByGroupService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> execute(String groupName) {
        return studentRepository.findByGroupName(groupName);
    }
}