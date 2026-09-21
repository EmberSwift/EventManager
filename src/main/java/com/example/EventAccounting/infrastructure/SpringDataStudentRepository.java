package com.example.EventAccounting.infrastructure;

import com.example.EventAccounting.infrastructure.StudentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataStudentRepository extends JpaRepository<StudentJpaEntity, Long> {
    List<StudentJpaEntity> findByGroupName(String groupName);
}