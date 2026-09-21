package com.example.EventAccounting.infrastructure;
import com.example.EventAccounting.domain.Student;
import com.example.EventAccounting.domain.StudentRepository;
import org.springframework.stereotype.Component; // ОБЯЗАТЕЛЬНО

import java.util.List;
import java.util.Optional;

@Component // <-- Позволяет Spring найти этот класс при сканировании бинов
public class StudentRepositoryAdapter implements StudentRepository {

    private final SpringDataStudentRepository springDataStudentRepository;

    public StudentRepositoryAdapter(SpringDataStudentRepository springDataStudentRepository) {
        this.springDataStudentRepository = springDataStudentRepository;
    }

    @Override
    public Student save(Student student) {
        StudentJpaEntity entity = new StudentJpaEntity(null, student.getFullName(), student.getGroupName());
        StudentJpaEntity saved = springDataStudentRepository.save(entity);
        return new Student(saved.getId(), saved.getFullName(), saved.getGroupName());
    }

    @Override
    public Optional<Student> findById(Long id) {
        return springDataStudentRepository.findById(id)
                .map(e -> new Student(e.getId(), e.getFullName(), e.getGroupName()));
    }

    @Override
    public List<Student> findAll() {
        return springDataStudentRepository.findAll().stream()
                .map(e -> new Student(e.getId(), e.getFullName(), e.getGroupName()))
                .toList();
    }

    @Override
    public List<Student> findByGroupName(String groupName) {
        return springDataStudentRepository.findByGroupName(groupName).stream()
                .map(e -> new Student(e.getId(), e.getFullName(), e.getGroupName()))
                .toList();
    }
}