package com.example.EventAccounting.domain;

public class Student {
    private Long id;
    private String fullName;
    private String groupName;

    public Student(Long id, String fullName, String groupName) {
        this.id = id;
        this.fullName = fullName;
        this.groupName = groupName;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getGroupName() { return groupName; }
}
