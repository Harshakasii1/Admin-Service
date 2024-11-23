package com.coursemanagement.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.app.dto.InstructorDTO;
import com.coursemanagement.app.entity.Instructor;
import com.coursemanagement.app.repository.InstructorRepository;

@Service
public class InstructorService {

	 @Autowired
	    private InstructorRepository instructorRepository;

	    // Add an instructor and generate password
	    public Instructor addInstructor(Instructor instructor) {
	        instructor.generatePassword();  // Generate password based on name and id
	        return instructorRepository.save(instructor);
	    }

	    // Convert Instructor to InstructorDTO
	    private InstructorDTO convertToDTO(Instructor instructor) {
	        List<Long> courseIds = instructor.getCourses().stream()
	                                        .map(course -> course.getId())
	                                        .collect(Collectors.toList());

	        return new InstructorDTO(instructor.getId(), instructor.getName(), instructor.getEmail(),
	                                 instructor.getPassword(), courseIds);
	    }

	    // Get all instructors and convert to DTOs
	    public List<InstructorDTO> getAllInstructors() {
	        return instructorRepository.findAll().stream()
	                                   .map(this::convertToDTO)
	                                   .collect(Collectors.toList());
	    }
}