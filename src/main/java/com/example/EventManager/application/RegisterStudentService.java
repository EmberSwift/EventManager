package com.example.EventManager.application;

import com.example.EventManager.domain.Student;
import com.example.EventManager.domain.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterStudentService {
    private final StudentRepository studentRepository;

    public RegisterStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(StudentCreateDto dto) {
        Student student = new Student(null, dto.fullName(), dto.groupName());
        return studentRepository.save(student);
    }
}
