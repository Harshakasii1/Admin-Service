package com.coursemanagement.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursemanagement.app.dto.InstructorDTO;
import com.coursemanagement.app.entity.Instructor;
import com.coursemanagement.app.service.InstructorService;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

	@Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        Instructor newInstructor = instructorService.addInstructor(instructor);
        return ResponseEntity.status(201).body(newInstructor);
    }

    @GetMapping
    public ResponseEntity<List<InstructorDTO>> getAllInstructors() {
        List<InstructorDTO> instructors = instructorService.getAllInstructors();
        return ResponseEntity.ok(instructors);
    }
}