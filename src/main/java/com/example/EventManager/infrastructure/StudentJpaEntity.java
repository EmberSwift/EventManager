package com.example.EventManager.infrastructure;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "students")
public class StudentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    public StudentJpaEntity() {}

    public StudentJpaEntity(Long id, String fullName, String groupName) {
        this.id = id;
        this.fullName = fullName;
        this.groupName = groupName;
    }

}