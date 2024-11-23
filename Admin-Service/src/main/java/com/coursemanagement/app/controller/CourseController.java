package com.coursemanagement.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursemanagement.app.dto.CourseDTO;
import com.coursemanagement.app.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	 @Autowired
	    private CourseService courseService;

	    // Create a new course
	    @PostMapping
	    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
	        CourseDTO createdCourseDTO = courseService.createCourse(courseDTO);
	        return ResponseEntity.status(201).body(createdCourseDTO);
	    }

	    // Get all courses
	    @GetMapping
	    public ResponseEntity<List<CourseDTO>> getAllCourses() {
	        List<CourseDTO> courses = courseService.getAllCourses();
	        return ResponseEntity.ok(courses);
	    }

	    // Update a course
	    @PutMapping("/{courseId}")
	    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {
	        CourseDTO updatedCourseDTO = courseService.updateCourse(courseId, courseDTO);
	        if (updatedCourseDTO != null) {
	            return ResponseEntity.ok(updatedCourseDTO);
	        }
	        return ResponseEntity.notFound().build();
	    }

	    // Delete a course
	    @DeleteMapping("/{courseId}")
	    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId) {
	        courseService.deleteCourse(courseId);
	        return ResponseEntity.ok().body("{ \"message\": \"Course deleted successfully.\" }");
	    }
}