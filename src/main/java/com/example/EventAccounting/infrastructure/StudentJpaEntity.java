package com.example.EventAccounting.infrastructure;

import jakarta.persistence.*;

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
}