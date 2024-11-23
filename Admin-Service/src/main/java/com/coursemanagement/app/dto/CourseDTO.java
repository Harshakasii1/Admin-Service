package com.coursemanagement.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String name;
    private String description;
    private List<Long> instructorIds; // List of instructor IDs that are assigned to this course

    // Constructor
    public CourseDTO(Long id, String name, String description, List<Long> instructorIds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructorIds = instructorIds;
    }
}
